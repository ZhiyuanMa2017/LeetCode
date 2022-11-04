class Solution {
    public int countNegatives(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int i = 0;
        int j = n - 1;
        int res = 0;
        while (i < m && j >= 0) {
            while (j >= 0 && grid[i][j] >= 0) {
                j--;
            }
            res += n - 1 - j;
            if (j == -1) {
                res += (m - 1 - i) * n;
                return res;
            }
            i++;
        }
        return res;
    }
}
