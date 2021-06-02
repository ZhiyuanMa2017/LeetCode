class Solution {

    private boolean[][] visited;
    private int[][] g;
    private int m;
    private int n;

    public int maxAreaOfIsland(int[][] grid) {
        g = grid;
        m = grid.length;
        n = grid[0].length;
        int res = 0;
        visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]) {
                    continue;
                }
                int tmp = 0;
                tmp = spread(i, j);
                res = Math.max(res, tmp);
            }
        }
        return res;
    }

    private int spread(int x, int y) {
        if (!inbound(x, y)) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }
        visited[x][y] = true;
        if (g[x][y] == 1) {
            return 1 + spread(x + 1, y) + spread(x - 1, y) + spread(x, y + 1) + spread(x, y - 1);
        } else {
            return 0;
        }

    }

    private boolean inbound(int x, int y) {
        return x >= 0 && y >= 0 && x <= m - 1 && y <= n - 1;
    }
}
