class Solution {
    public int maxA(int n) {
        if (n <= 6) {
            return n;
        }
        int[] dp = new int[n + 1];
        for (int i = 0; i < 6; i++) {
            dp[i] = i;
        }
        for (int i = 7; i <= n; i++) {
            dp[i] = Math.max(dp[i - 3] * 2, dp[i]);
            dp[i] = Math.max(dp[i - 4] * 3, dp[i]);
            dp[i] = Math.max(dp[i - 5] * 4, dp[i]);
            dp[i] = Math.max(dp[i - 6] * 5, dp[i]);
        }
        return dp[n];
    }
}
