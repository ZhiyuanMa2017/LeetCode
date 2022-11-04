class Solution {
    public int[] findBall(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] res = new int[n];
        for (int j = 0; j < n; j++) {
            res[j] = helper(grid, j);
        }
        return res;
    }

    private int helper(int[][] grid, int col) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0;
        int j = col;
        while (i < m) {
            int newJ = j + grid[i][j];
            if (newJ < 0 || newJ >= n) {
                return -1;
            }
            if (grid[i][j] != grid[i][newJ]) {
                return -1;
            }
            j = newJ;
            i++;
        }
        return j;
    }
}
