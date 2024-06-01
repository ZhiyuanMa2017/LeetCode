import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> longestCommonSubsequence(int[][] arrays) {
        int n = arrays.length;
        List<Integer> lcs = new ArrayList<>();
        for (int num : arrays[0]) {
            lcs.add(num);
        }
        for (int i = 1; i < n; i++) {
            lcs = helper(lcs, arrays[i]);
        }
        return lcs;
    }

    private List<Integer> helper(List<Integer> lcs, int[] nums) {
        List<Integer> res = new ArrayList<>();
        int i = 0;
        int j = 0;
        while (i < lcs.size() && j < nums.length) {
            if (lcs.get(i) == nums[j]) {
                res.add(nums[j]);
                i++;
                j++;
            } else if (lcs.get(i) < nums[j]) {
                i++;
            } else {
                j++;
            }
        }
        return res;
    }
}
