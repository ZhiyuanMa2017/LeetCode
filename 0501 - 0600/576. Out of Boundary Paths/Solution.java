class Solution {
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        int[][] dp = new int[m][n];
        dp[startRow][startColumn] = 1;
        int res = 0;
        int modulo = 1000000007;
        int[][] dirs = new int[][]{{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0; i < maxMove; i++) {
            int[][] tmp = new int[m][n];
            for (int j = 0; j < m; j++) {
                for (int k = 0; k < n; k++) {
                    for (int[] dir : dirs) {
                        int jm = j + dir[0];
                        int kn = k + dir[1];
                        if (jm < 0 || jm >= m || kn < 0 || kn >= n) {
                            res = (res + dp[j][k]) % modulo;
                        } else {
                            tmp[jm][kn] = (tmp[jm][kn] + dp[j][k]) % modulo;
                        }
                    }
                }
            }
            dp = tmp;
        }
        return res;
    }
}
