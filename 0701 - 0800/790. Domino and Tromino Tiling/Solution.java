class Solution {
    public int numTilings(int n) {
        if (n <= 2) {
            return n;
        }
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = (dp[i - 1] * 2 % mod + dp[i - 3]) % mod;
        }
        return dp[n];
    }
}
