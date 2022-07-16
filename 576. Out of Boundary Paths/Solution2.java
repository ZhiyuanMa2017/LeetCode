import java.util.Arrays;

class Solution {
    int M;
    int N;
    int[][][] memo;
    int mod;
    int[] dirs;

    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        memo = new int[m][n][maxMove + 1];
        M = m;
        N = n;
        mod = 1000000007;
        dirs = new int[]{-1, 0, 1, 0, -1};
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                Arrays.fill(memo[i][j], -1);
            }
        }
        return dfs(startRow, startColumn, maxMove);
    }

    private int dfs(int x, int y, int k) {
        if (x < 0 || x >= M || y < 0 || y >= N) {
            return 1;
        }
        if (k == 0) {
            return 0;
        }
        if (memo[x][y][k] != -1) {
            return memo[x][y][k];
        }
        int res = 0;
        for (int i = 0; i < 4; i++) {
            int newX = x + dirs[i];
            int newY = y + dirs[i + 1];
            res = (res + dfs(newX, newY, k - 1)) % mod;
        }
        memo[x][y][k] = res;
        return res;
    }
}
