class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int dis = Math.abs(startPos - endPos);
        int mod = 1000000007;
        if ((dis + k) % 2 == 1 || dis > k) {
            return 0;
        }
        long[][] f = new long[k + 1][k + 1];
        for (int i = 0; i <= k; i++) {
            f[i][0] = 1;
            for (int j = 1; j <= i; j++) {
                f[i][j] = (f[i - 1][j] + f[i - 1][j - 1]) % mod;
            }
        }
        return (int) f[k][(dis + k) / 2];
    }
}
