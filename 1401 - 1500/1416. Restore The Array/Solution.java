class Solution {
    public int numberOfArrays(String s, int k) {
        int n = s.length();
        int mod = (int) (1e9 + 7);
        long[] dp = new long[n + 1];
        dp[n] = 1;
        for (int i = n - 1; i >= 0; i--) {
            long cur = s.charAt(i) - '0';
            if (cur >= 1 && cur <= k) {
                dp[i] = (dp[i] + dp[i + 1]) % mod;
                for (int j = i + 1; j < n; j++) {
                    cur = cur * 10 + s.charAt(j) - '0';
                    if (cur <= k) {
                        dp[i] = (dp[i] + dp[j + 1]) % mod;
                    } else {
                        break;
                    }
                }
            }
        }
        return (int) dp[0];
    }
}
