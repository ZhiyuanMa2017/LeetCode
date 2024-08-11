class Solution {
    public int minDays(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int total = count(grid);
        if (total != 1) {
            return 0;
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    int cur = count(grid);
                    if (cur > 1 || cur == 0) {
                        return 1;
                    }
                    grid[i][j] = 1;
                }
            }
        }
        return 2;
    }

    private int count(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int res = 0;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    res++;
                    dfs(grid, i, j, visited);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j, boolean[][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (i >= 0 && j >= 0 && i < m && j < n && grid[i][j] == 1 && !visited[i][j]) {
            visited[i][j] = true;
            dfs(grid, i + 1, j, visited);
            dfs(grid, i, j + 1, visited);
            dfs(grid, i - 1, j, visited);
            dfs(grid, i, j - 1, visited);
        }
    }
}
