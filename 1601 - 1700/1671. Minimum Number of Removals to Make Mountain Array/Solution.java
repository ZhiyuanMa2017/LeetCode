import java.util.Arrays;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        Arrays.fill(left, 1);
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (nums[j] > nums[i]) {
                    left[j] = Math.max(left[j], left[i] + 1);
                }
            }
        }
        int[] right = new int[n];
        Arrays.fill(right, 1);
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] > nums[i]) {
                    right[j] = Math.max(right[j], right[i] + 1);
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (left[i] >= 2 && right[i] >= 2) {
                res = Math.max(res, left[i] + right[i] - 1);
            }
        }
        return n - res;
    }
}
