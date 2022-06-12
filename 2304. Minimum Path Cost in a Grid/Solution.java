class Solution {
    public int minPathCost(int[][] grid, int[][] moveCost) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = grid[i][j];
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                int cur = Integer.MAX_VALUE;
                for (int p = 0; p < n; p++) {
                    int last = grid[i - 1][p];
                    int cost = moveCost[last][j];
                    cost += dp[i - 1][p];
                    cur = Math.min(cur, cost);
                }
                dp[i][j] += cur;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < n; j++) {
            res = Math.min(res, dp[m - 1][j]);
        }
        return res;
    }
}
