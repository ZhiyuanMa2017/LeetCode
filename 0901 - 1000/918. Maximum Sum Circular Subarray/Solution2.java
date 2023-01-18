class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n = nums.length;
        int[] suffixSum = new int[n];
        int[] rightMax = new int[n];
        suffixSum[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = nums[i] + suffixSum[i + 1];
            rightMax[i] = Math.max(rightMax[i + 1], suffixSum[i + 1]);
        }
        int curMax = nums[0];
        int preSum = nums[0];
        int res = Math.max(preSum, preSum + rightMax[0]);
        for (int i = 1; i < nums.length; i++) {
            curMax = Math.max(curMax + nums[i], nums[i]);
            preSum += nums[i];
            res = Math.max(res, curMax);
            res = Math.max(res, preSum + rightMax[i]);
        }
        return res;
    }
}
