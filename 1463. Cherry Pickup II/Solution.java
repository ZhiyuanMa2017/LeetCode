class Solution {
    int[][] g;
    int n;
    int m;
    int[][][] dp;

    public int cherryPickup(int[][] grid) {
        n = grid.length;
        m = grid[0].length;
        g = grid;
        dp = new int[n][m][m];
        return dfs(0, 0, m - 1);
    }

    private int dfs(int row, int column1, int column2) {
        if (row == n) {
            return 0;
        }
        if (dp[row][column1][column2] > 0) {
            return dp[row][column1][column2];
        }
        int res = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                int newColumn1 = column1 + i;
                int newColumn2 = column2 + j;
                if (newColumn2 >= 0 && newColumn2 < m && newColumn1 >= 0 && newColumn1 < m) {
                    res = Math.max(res, dfs(row + 1, newColumn1, newColumn2));
                }
            }
        }
        res += column1 == column2 ? g[row][column1] : g[row][column1] + g[row][column2];
        dp[row][column1][column2] = res;
        return res;
    }
}
