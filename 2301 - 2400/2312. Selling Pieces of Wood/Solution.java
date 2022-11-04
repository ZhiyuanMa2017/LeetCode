class Solution {
    public long sellingWood(int m, int n, int[][] prices) {
        long[][] dp = new long[m + 1][n + 1];
        for (int[] price : prices) {
            int h = price[0];
            int w = price[1];
            int value = price[2];
            dp[h][w] = value;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k < i; k++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - k][j] + dp[k][j]);
                }
                for (int p = 1; p < j; p++) {
                    dp[i][j] = Math.max(dp[i][j], dp[i][j - p] + dp[i][p]);
                }
            }
        }
        return dp[m][n];
    }
}
