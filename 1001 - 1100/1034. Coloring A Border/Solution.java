class Solution {
    int[] dirs = new int[]{-1, 0, 1, 0, -1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {
        dfs(grid, row, col, color);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    grid[i][j] = color;
                }
            }
        }
        return grid;
    }

    private void dfs(int[][] grid, int row, int col, int color) {
        int before = grid[row][col];
        grid[row][col] = -before;
        for (int i = 0; i < 4; i++) {
            int x = row + dirs[i];
            int y = col + dirs[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && grid[x][y] == before) {
                dfs(grid, x, y, color);
            }
        }

        int count = 0;
        for (int i = 0; i < 4; i++) {
            int x = row + dirs[i];
            int y = col + dirs[i + 1];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && Math.abs(grid[x][y]) == before) {
                count++;
            }
        }
        if (count == 4) {
            grid[row][col] = before;
        }
    }
}
