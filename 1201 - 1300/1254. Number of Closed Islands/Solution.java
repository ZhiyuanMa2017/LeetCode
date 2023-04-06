class Solution {
    static int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int closedIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    if (dfs(grid, i, j)) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] grid, int i, int j) {
        grid[i][j] = 1;
        int m = grid.length;
        int n = grid[0].length;
        boolean res = true;
        if (i == 0 || i == m - 1 || j == 0 || j == n - 1) {
            res = false;
        }
        for (int p = 0; p < 4; p++) {
            int x = i + dirs[p];
            int y = j + dirs[p + 1];
            if (x >= 0 && x < m && y >= 0 && y < n && grid[x][y] == 0) {
                res = dfs(grid, x, y) && res;
            }
        }
        return res;
    }
}
