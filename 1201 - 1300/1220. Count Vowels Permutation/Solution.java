class Solution {
    public int countVowelPermutation(int n) {
        long[] dp = new long[5];
        int mod = 1000000007;
        for (int i = 0; i < 5; i++) {
            dp[i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            long[] tmp = new long[5];
            tmp[0] = (dp[1] + dp[2] + dp[4]) % mod;
            tmp[1] = (dp[0] + dp[2]) % mod;
            tmp[2] = (dp[1] + dp[3]) % mod;
            tmp[3] = (dp[2]) % mod;
            tmp[4] = (dp[2] + dp[3]) % mod;
            dp = tmp;
        }
        long res = 0;
        for (long l : dp) {
            res = (res + l) % mod;
        }
        return (int) res;
    }
}
