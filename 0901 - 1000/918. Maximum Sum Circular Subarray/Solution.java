class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int max = nums[0];
        int curMax = nums[0];
        int sum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            max = Math.max(max, curMax);
            sum += nums[i];
        }
        int curMin = 0;
        int min = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            curMin = Math.min(curMin + nums[i], nums[i]);
            min = Math.min(min, curMin);
        }
        return Math.max(max, sum - min);
    }
}
