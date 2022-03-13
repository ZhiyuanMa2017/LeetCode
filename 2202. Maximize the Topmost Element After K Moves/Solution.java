class Solution {
    public int maximumTop(int[] nums, int k) {
        int n = nums.length;
        if (n == 1) {
            if (k % 2 == 0) {
                return nums[0];
            }
            return -1;
        }
        if (k == 1) {
            return nums[1];
        }
        if (k > n) {
            int max = nums[0];
            for (int i = 1; i < nums.length; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        if (k == n) {
            int max = nums[0];
            for (int i = 0; i < nums.length - 1; i++) {
                max = Math.max(max, nums[i]);
            }
            return max;
        }
        int max = nums[0];
        for (int i = 1; i < k - 1; i++) {
            max = Math.max(max, nums[i]);
        }
        return Math.max(max, nums[k]);
    }
}
