class Solution {
    public int[][] largestLocal(int[][] grid) {
        int n = grid.length;
        int[][] res = new int[n - 2][n - 2];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = center(grid, i + 1, j + 1);
            }
        }
        return res;
    }

    private int center(int[][] grid, int x, int y) {
        int res = 0;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                res = Math.max(res, grid[i][j]);
            }
        }
        return res;
    }
}
