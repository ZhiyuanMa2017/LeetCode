class Solution {
    int[][] memo;
    int mod = 1000000007;

    public int countPaths(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        memo = new int[m][n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                res = (res + dfs(grid, i, j, 0)) % mod;
            }
        }
        return res;
    }

    private int dfs(int[][] grid, int i, int j, int previous) {
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] <= previous) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        memo[i][j] = 1;
        memo[i][j] = (memo[i][j] + dfs(grid, i + 1, j, grid[i][j])) % mod;
        memo[i][j] = (memo[i][j] + dfs(grid, i - 1, j, grid[i][j])) % mod;
        memo[i][j] = (memo[i][j] + dfs(grid, i, j + 1, grid[i][j])) % mod;
        memo[i][j] = (memo[i][j] + dfs(grid, i, j - 1, grid[i][j])) % mod;
        return memo[i][j];
    }
}
