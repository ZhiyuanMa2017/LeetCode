import java.util.Arrays;

class Solution {
    public int distinctSubseqII(String s) {
        int mod = 1000000007;
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        int[] last = new int[26];
        Arrays.fill(last, -1);
        for (int i = 0; i < n; i++) {
            char cur = s.charAt(i);
            dp[i + 1] = dp[i] * 2 % mod;
            if (last[cur - 'a'] >= 0) {
                dp[i + 1] = (dp[i + 1] - dp[last[cur - 'a']]) % mod;
            }
            last[cur - 'a'] = i;
        }
        return (dp[n] - 1 + mod) % mod;
    }
}
