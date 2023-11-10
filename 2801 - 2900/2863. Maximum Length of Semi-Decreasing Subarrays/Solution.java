import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxSubarrayLength(int[] nums) {
        int n = nums.length;
        int res = 0;
        List<Integer> increasing = new ArrayList<>();
        increasing.add(0);
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            if (num < nums[increasing.get(0)]) {
                res = Math.max(res, i + 1);
            } else if (num > nums[increasing.get(increasing.size() - 1)]) {
                increasing.add(i);
            } else if (num == nums[increasing.get(increasing.size() - 1)]) {
                continue;
            } else {
                int first = binarySearch(increasing, num, nums);
                res = Math.max(res, i - first + 1);
            }
        }
        return res;
    }

    private int binarySearch(List<Integer> list, int num, int[] nums) {
        int n = list.size();
        int l = 0;
        int r = n - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (nums[list.get(mid)] <= num) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.get(l);
    }
}
