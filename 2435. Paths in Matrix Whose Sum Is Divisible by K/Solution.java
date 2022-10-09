class Solution {
    public int numberOfPaths(int[][] grid, int k) {
        int mod = 1000000007;
        int m = grid.length;
        int n = grid[0].length;
        int[][][] dp = new int[m][n][k];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int val = grid[i][j];
                if (i == 0 && j == 0) {
                    dp[i][j][val % k] = 1;
                }
                for (int p = 0; p < k; p++) {
                    int cur = (val + p) % k;
                    if (i > 0) {
                        dp[i][j][cur] = (dp[i][j][cur] + dp[i - 1][j][p]) % mod;
                    }
                    if (j > 0) {
                        dp[i][j][cur] = (dp[i][j][cur] + dp[i][j - 1][p]) % mod;
                    }
                }
            }
        }
        return dp[m - 1][n - 1][0];
    }
}
