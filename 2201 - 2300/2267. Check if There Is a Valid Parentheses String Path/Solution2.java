class Solution2 {

    public boolean hasValidPath(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        if (grid[0][0] == ')') {
            return false;
        }
        if (grid[m - 1][n - 1] == '(') {
            return false;
        }
        if ((m + n - 1) % 2 != 0) {
            return false;
        }
        boolean[][][] visited = new boolean[101][101][200];
        return dfs(grid, 0, 0, 0, visited);
    }

    private boolean dfs(char[][] grid, int x, int y, int score, boolean[][][] visited) {
        int m = grid.length;
        int n = grid[0].length;
        if (x >= m || x < 0 || y >= n || y < 0 || score < 0) {
            return false;
        }
        if (visited[x][y][score]) {
            return false;
        }
        visited[x][y][score] = true;
        score += grid[x][y] == '(' ? 1 : -1;
        if (x == m - 1 && y == n - 1) {
            return score == 0;
        }
        return dfs(grid, x + 1, y, score, visited) || dfs(grid, x, y + 1, score, visited);
    }
}
