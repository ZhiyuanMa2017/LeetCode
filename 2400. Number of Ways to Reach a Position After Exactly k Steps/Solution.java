class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        long[][] dp = new long[1001][3001];
        int mod = 1000000007;
        dp[0][startPos + 1000] = 1;
        for (int i = 1; i <= k; i++) {
            for (int col = 0; col <= 3000; col++) {
                if (dp[i - 1][col] != 0) {
                    dp[i][col + 1] = (dp[i][col + 1] + dp[i - 1][col]) % mod;
                    dp[i][col - 1] = (dp[i][col - 1] + dp[i - 1][col]) % mod;
                }
            }
        }
        return (int) dp[k][endPos + 1000];
    }
}
