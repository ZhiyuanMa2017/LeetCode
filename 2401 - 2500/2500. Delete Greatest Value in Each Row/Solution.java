import java.util.Arrays;

class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int res = 0;
        int m = grid.length;
        for (int i = 0; i < m; i++) {
            Arrays.sort(grid[i]);
        }
        int n = grid[0].length;
        for (int j = 0; j < n; j++) {
            int max = 0;
            for (int i = 0; i < m; i++) {
                max = Math.max(max, grid[i][j]);
            }
            res += max;
        }
        return res;
    }
}
