class Solution2 {
    public int numDecodings(String s) {
        int n = s.length();
        s = " " + s;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i <= n; i++) {
            char c = s.charAt(i);
            if (c != '0') {
                dp[i] += dp[i - 1];
            }
            if (i > 1) {
                int num = Integer.parseInt(s.substring(i - 1, i + 1));
                if (num >= 10 && num <= 26) {
                    dp[i] += dp[i - 2];
                }
            }
        }
        return dp[n];
    }
}
