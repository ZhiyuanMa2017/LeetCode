class Solution {
    public boolean winnerSquareGame(int n) {
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i <= n; i++) {
            if (!dp[i]) {
                for (int k = 1; k * k + i <= n; k++) {
                    dp[i + k * k] = true;
                }
            }
        }
        return dp[n];
    }
}
