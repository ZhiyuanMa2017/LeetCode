class Solution {
    public int maxKilledEnemies(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int curRowHits = 0;
        int[] colHits = new int[n];
        int res = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (j == 0 || grid[i][j - 1] == 'W') {
                    curRowHits = 0;
                    for (int k = j; k < n; k++) {
                        if (grid[i][k] == 'W') {
                            break;
                        } else if (grid[i][k] == 'E') {
                            curRowHits++;
                        }
                    }
                }
                if (i == 0 || grid[i - 1][j] == 'W') {
                    colHits[j] = 0;
                    for (int p = i; p < m; p++) {
                        if (grid[p][j] == 'W') {
                            break;
                        } else if (grid[p][j] == 'E') {
                            colHits[j]++;
                        }
                    }
                }
                if (grid[i][j] == '0') {
                    res = Math.max(res, curRowHits + colHits[j]);
                }
            }
        }
        return res;
    }
}
