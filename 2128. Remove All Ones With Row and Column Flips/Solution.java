class Solution {
    public boolean removeOnes(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] cur = new int[m][n];
        for (int i = 0; i < m; i++) {
            if (cur[i][0] != grid[i][0]) {
                for (int j = 0; j < n; j++) {
                    cur[i][j] = 1 - cur[i][j];
                }
            }
        }
        for (int j = 1; j < n; j++) {
            if (cur[0][j] != grid[0][j]) {
                for (int i = 0; i < m; i++) {
                    cur[i][j] = 1 - cur[i][j];
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cur[i][j] != grid[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
