import java.util.ArrayList;
import java.util.List;

class Solution {
    public int kIncreasing(int[] arr, int k) {
        int res = 0;
        List<List<Integer>> list = new ArrayList<>();
        for (int start = 0; start < k; start++) {
            List<Integer> thisList = new ArrayList<>();
            for (int i = start; i < arr.length; i += k) {
                thisList.add(arr[i]);
            }
            list.add(thisList);
        }
        for (List<Integer> curList : list) {
            res += lengthOfLIS(curList);
        }
        return res;
    }

    public int lengthOfLIS(List<Integer> nums) {
        int[] tails = new int[nums.size()];
        int size = 0;
        for (int num : nums) {
            int i = 0;
            int j = size;
            while (i < j) {
                int mid = i + (j - i) / 2;
                if (tails[mid] <= num) {
                    i = mid + 1;
                } else {
                    j = mid;
                }
            }
            tails[i] = num;
            if (i == size) {
                size++;
            }
        }
        return nums.size() - size;
    }
}
