class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int res = 0;
        int m = grid1.length;
        int n = grid1[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1) {
                    if (dfs(grid1, grid2, i, j)) {
                        System.out.println(i + " " + j);
                        res++;
                    }
                }
            }
        }
        return res;
    }

    private boolean dfs(int[][] g1, int[][] g2, int i, int j) {
        if (i < 0 || i >= g1.length || j < 0 || j >= g1[0].length) {
            return true;
        }
        if (g2[i][j] == 0) {
            return true;
        }
        if (g1[i][j] == 0) {
            return false;
        }
        g2[i][j] = 0;
        boolean res = true;
        res &= dfs(g1, g2, i + 1, j);
        res &= dfs(g1, g2, i - 1, j);
        res &= dfs(g1, g2, i, j + 1);
        res &= dfs(g1, g2, i, j - 1);
        return res;
    }
}
