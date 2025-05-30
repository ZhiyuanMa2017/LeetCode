class Solution {
    public int largest1BorderedSquare(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] right = new int[m][n];
        int[][] down = new int[m][n];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 1) {
                    right[i][j] = j < n - 1 ? right[i][j + 1] + 1 : 1;
                    down[i][j] = i < m - 1 ? down[i + 1][j] + 1 : 1;
                }
            }
        }
        int maxLen = Math.min(m, n);
        for (int len = maxLen; len >= 1; len--) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (right[i][j] < len) {
                        continue;
                    }
                    if (down[i][j] < len) {
                        continue;
                    }
                    int topRight = j + len - 1;
                    int downLeft = i + len - 1;
                    if (topRight >= n || downLeft >= m) {
                        continue;
                    }
                    if (down[i][topRight] < len) {
                        continue;
                    }
                    if (right[downLeft][j] < len) {
                        continue;
                    }
                    return len * len;
                }
            }
        }
        return 0;
    }
}
