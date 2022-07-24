class Solution {
    public int equalPairs(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (same(grid, i, j)) {
                    res++;
                }
            }
        }
        return res;
    }

    private boolean same(int[][] grid, int row, int col) {
        int n = grid.length;
        for (int i = 0; i < n; i++) {
            if (grid[row][i] != grid[i][col]) {
                return false;
            }
        }
        return true;
    }
}
