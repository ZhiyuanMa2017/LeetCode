class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        char[] string = (" " + s).toCharArray();
        char[] pattern = (" " + p).toCharArray();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (pattern[j] == '?' || pattern[j] == string[i]) {
                    dp[i][j] = i > 0 && dp[i - 1][j - 1];
                } else if (pattern[j] == '*') {
                    dp[i][j] = (i > 0 && dp[i - 1][j]) || dp[i][j - 1];
                }
            }
        }
        return dp[n][m];
    }
}
