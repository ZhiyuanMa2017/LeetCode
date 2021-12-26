class Solution {
    public int[] getSumAbsoluteDifferences(int[] nums) {
        int n = nums.length;
        int rSum = 0;
        for (int i = 0; i < n; i++) {
            rSum += nums[i];
        }
        int[] res = new int[n];
        int lSum = 0;

        for (int i = 0; i < n; i++) {
            rSum -= nums[i];
            int leftSum = nums[i] * i - lSum;
            int rightSum = rSum - (n - 1 - i) * nums[i];
            res[i] = leftSum + rightSum;
            lSum += nums[i];

        }
        return res;
    }
}
