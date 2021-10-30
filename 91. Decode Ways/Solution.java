class Solution {
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        dp[0] = s.charAt(0) == '0' ? 0 : 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) != '0') {
                dp[i] = dp[i - 1];
            }
            int two = Integer.parseInt(s.substring(i - 1, i + 1));
            if (two >= 10 && two <= 26) {
                dp[i] += i > 1 ? dp[i - 2] : 1;
            }
        }
        return dp[n - 1];
    }
}
