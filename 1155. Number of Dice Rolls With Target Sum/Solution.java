class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[][] dp = new int[n + 1][target + 1];
        int mod = 1000000007;
        for (int i = 1; i <= Math.min(k, target); i++) {
            dp[1][i] = 1;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 2; j <= target; j++) {
                for (int d = 1; d <= k; d++) {
                    if (j > d) {
                        dp[i][j] = (dp[i][j] + dp[i - 1][j - d]) % mod;
                    }
                }
            }
        }
        return dp[n][target];
    }
}
