class Solution {
    public boolean possibleToStamp(int[][] grid, int h, int w) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] sum = new int[m + 1][n + 1];
        int[][] diff = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                sum[i + 1][j + 1] = sum[i][j + 1] + sum[i + 1][j] - sum[i][j] + grid[i][j];
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    int rightBottomX = i + h;
                    int rightBottomY = j + w;
                    if (rightBottomX <= m && rightBottomY <= n
                            && (sum[rightBottomX][rightBottomY] - sum[rightBottomX][j] - sum[i][rightBottomY] + sum[i][j] == 0)) {
                        diff[i][j]++;
                        diff[rightBottomX][j]--;
                        diff[i][rightBottomY]--;
                        diff[rightBottomX][rightBottomY]++;
                    }
                }
            }
        }

        int[] cnt = new int[n + 1];
        int[] pre = new int[n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt[j + 1] = cnt[j] + pre[j + 1] - pre[j] + diff[i][j];
                if (cnt[j + 1] == 0 && grid[i][j] == 0) {
                    return false;
                }
            }
            pre = cnt;
            cnt = new int[n + 1];
        }
        return true;
    }
}
