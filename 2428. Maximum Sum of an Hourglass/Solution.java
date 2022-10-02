class Solution {
    public int maxSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 1; i < m - 1; i++) {
            for (int j = 1; j < n - 1; j++) {
                int a = grid[i - 1][j - 1];
                int b = grid[i - 1][j];
                int c = grid[i - 1][j + 1];
                int d = grid[i][j];
                int e = grid[i + 1][j - 1];
                int f = grid[i + 1][j];
                int g = grid[i + 1][j + 1];
                res = Math.max(res, a + b + c + d + e + f + g);
            }
        }
        return res;
    }
}
