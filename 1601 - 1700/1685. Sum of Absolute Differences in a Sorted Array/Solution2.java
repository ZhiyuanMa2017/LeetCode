class Solution2 {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int sum = 0;
        int n = nums.length;
        int[] res = new int[n];
        for (int num : nums) {
            sum += num;
        }
        int preSum = 0;

        for (int i = 0; i < n; i++) {
            preSum += nums[i];
            int leftSum = i * nums[i] - (preSum - nums[i]);
            int rightSum = sum - preSum - (n - i - 1) * nums[i];
            res[i] = leftSum + rightSum;
        }
        return res;

    }
}
