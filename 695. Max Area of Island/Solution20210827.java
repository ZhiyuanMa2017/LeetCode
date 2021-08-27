class Solution20210827 {
    private int[] dirs = new int[]{0, 1, 0, -1, 0};

    public int maxAreaOfIsland(int[][] grid) {
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    res = Math.max(res, area(grid, i, j));
                }
            }
        }
        return res;
    }

    private int area(int[][] grid, int i, int j) {
        int res = 0;
        if (i >= 0 && i < grid.length && j >= 0 && j < grid[0].length && grid[i][j] == 1) {
            grid[i][j] = 0;
            res += 1;
            for (int k = 0; k < 4; k++) {
                res += area(grid, i + dirs[k], j + dirs[k + 1]);
            }
        }
        return res;
    }
}
