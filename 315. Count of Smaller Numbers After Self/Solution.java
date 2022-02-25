import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        List<Integer> right = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        for (int i = n - 1; i >= 0; i--) {
            int count = searchPos(right, nums[i]);
            res.add(count);
        }
        Collections.reverse(res);
        return res;
    }

    private int searchPos(List<Integer> list, int num) {
        int n = list.size();
        if (list.isEmpty() || num > list.get(n - 1)) {
            list.add(num);
            return n;
        }
        if (num <= list.get(0)) {
            list.add(0, num);
            return 0;
        }
        int left = 0;
        int right = n - 1;
        while (left < right) {
            int mid = left + (right - left + 1) / 2;
            if (list.get(mid) >= num) {
                right = mid - 1;
            } else if (list.get(mid) < num) {
                left = mid;
            }
        }
        list.add(right + 1, num);
        return right + 1;

    }
}
