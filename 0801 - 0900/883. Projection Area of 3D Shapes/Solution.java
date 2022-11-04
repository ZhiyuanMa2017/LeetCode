class Solution {
    public int projectionArea(int[][] grid) {
        int n = grid.length;
        int res = 0;
        for (int i = 0; i < n; i++) {
            int curRow = 0;
            int curCol = 0;
            for (int j = 0; j < n; j++) {
                if (grid[i][j] != 0) {
                    res++;
                }
                curRow = Math.max(curRow, grid[i][j]);
                curCol = Math.max(curCol, grid[j][i]);
            }
            res += curCol + curRow;
        }
        return res;
    }
}
