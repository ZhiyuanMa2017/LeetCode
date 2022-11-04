class Solution {
    public int distinctSequences(int n) {
        if (n == 1) {
            return 6;
        }
        int[][][] dp = new int[n + 1][7][7];
        int mod = 1000000007;
        for (int i = 1; i <= 6; i++) {
            for (int j = 1; j <= 6; j++) {
                if (gcd(i, j) == 1 && i != j) {
                    dp[2][i][j] = 1;
                }
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int x = 1; x <= 6; x++) {
                for (int y = 1; y <= 6; y++) {
                    for (int z = 1; z <= 6; z++) {
                        if (gcd(x, y) == 1 && gcd(y, z) == 1 && x != y && x != z && y != z) {
                            dp[i][y][z] = (dp[i][y][z] + dp[i - 1][x][y]) % mod;
                        }
                    }
                }
            }
        }
        int res = 0;
        for (int x = 1; x <= 6; x++) {
            for (int y = 1; y <= 6; y++) {
                res = (res + dp[n][x][y]) % mod;
            }
        }
        return res;
    }

    private int gcd(int a, int b) {
        if (a % b == 0) {
            return b;
        }
        return gcd(b, a % b);
    }
}
