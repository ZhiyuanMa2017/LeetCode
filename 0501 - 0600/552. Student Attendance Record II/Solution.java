class Solution {
    int mod = (int) (1e9 + 7);
    int[][][] cache;

    public int checkRecord(int n) {
        cache = new int[n + 1][2][3];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < 2; j++) {
                for (int k = 0; k < 3; k++) {
                    cache[i][j][k] = -1;
                }
            }
        }
        return dfs(n, 0, 0);
    }

    private int dfs(int n, int a, int l) {
        if (a >= 2) {
            return 0;
        }
        if (l >= 3) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (cache[n][a][l] != -1) {
            return cache[n][a][l];
        }
        int res = dfs(n - 1, a, 0);
        res = (res + dfs(n - 1, a + 1, 0)) % mod;
        res = (res + dfs(n - 1, a, l + 1)) % mod;
        cache[n][a][l] = res;
        return res;
    }
}
