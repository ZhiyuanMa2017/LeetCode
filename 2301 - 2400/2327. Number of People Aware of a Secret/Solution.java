class Solution {
    public int peopleAwareOfSecret(int n, int delay, int forget) {
        int mod = 1000000007;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = i + delay; j < Math.min(i + forget, n + 1); j++) {
                dp[j] = (dp[j] + dp[i]) % mod;
            }
        }
        int res = 0;
        for (int i = 0; i < forget; i++) {
            res = (res + dp[n - i]) % mod;
        }
        return res;
    }
}
