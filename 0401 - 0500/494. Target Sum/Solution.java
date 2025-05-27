class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int[][] dp = new int[n][2001];
        dp[0][nums[0] + 1000] = 1;
        dp[0][-nums[0] + 1000] += 1;
        for (int i = 1; i < n; i++) {
            for (int sum = -1000; sum <= 1000; sum++) {
                if (dp[i - 1][sum + 1000] >= 0) {
                    int add = sum + nums[i];
                    if (add <= 1000) {
                        dp[i][add + 1000] += dp[i - 1][sum + 1000];
                    }
                    int minus = sum - nums[i];
                    if (minus >= -1000) {
                        dp[i][minus + 1000] += dp[i - 1][sum + 1000];
                    }
                }
            }
        }
        return dp[n - 1][target + 1000];
    }
}
