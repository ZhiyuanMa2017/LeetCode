class Solution2 {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int cur = 0;
        for (int i = 2; i <= n; i++) {
            if (i - delay >= 1) {
                cur = (cur + dp[i - delay]) % mod;
            }
            if (i - forget >= 1) {
                cur = (cur - dp[i - forget] + mod) % mod;
            }
            dp[i] = cur;
        }
        int res = 0;
        for (int i = 0; i < forget; i++) {
            res = (res + dp[n - i]) % mod;
        }
        return res;
    }
}
