class Solution {
    int res;
    int empty;
    int[][] g;

    public int uniquePathsIII(int[][] grid) {
        res = 0;
        empty = 0;
        g = grid;
        int startX = -1;
        int startY = -1;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 0) {
                    empty++;
                }
                if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }
        backtrack(startX, startY);
        return res;
    }

    private void backtrack(int i, int j) {
        if (i < 0 || j < 0 || i >= g.length || j >= g[0].length || g[i][j] < 0) {
            return;
        }
        if (g[i][j] == 2) {
            if (empty == -1) {
                res++;
            }
            return;
        }
        g[i][j] = -2;
        empty--;
        backtrack(i + 1, j);
        backtrack(i, j + 1);
        backtrack(i - 1, j);
        backtrack(i, j - 1);
        empty++;
        g[i][j] = 0;
    }
}
