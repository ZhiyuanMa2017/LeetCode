class Solution {
    public boolean checkValidGrid(int[][] grid) {
        if (grid[0][0] != 0) {
            return false;
        }
        int n = grid.length;
        int[][] steps = new int[n * n][2];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                int cur = grid[i][j];
                steps[cur] = new int[]{i, j};
            }
        }
        for (int i = 0; i < n * n - 1; i++) {
            int x1 = steps[i][0];
            int y1 = steps[i][1];
            int x2 = steps[i + 1][0];
            int y2 = steps[i + 1][1];
            if (Math.abs(x1 - x2) == 2 && Math.abs(y1 - y2) == 1) {
                continue;
            }
            if (Math.abs(x1 - x2) == 1 && Math.abs(y1 - y2) == 2) {
                continue;
            }
            return false;
        }
        return true;
    }
}
