class Solution {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        String ss = " " + s;
        String pp = " " + p;
        char[] sChars = ss.toCharArray();
        char[] pChars = pp.toCharArray();
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (j + 1 <= m && pChars[j + 1] == '*') {
                    continue;
                }
                if (i - 1 >= 0 && pChars[j] != '*') {
                    dp[i][j] = dp[i - 1][j - 1] && (pChars[j] == '.' || sChars[i] == pChars[j]);
                } else if (pChars[j] == '*') {
                    dp[i][j] = (j - 2 >= 0 && dp[i][j - 2]) || (i - 1 >= 0 && dp[i - 1][j] && (sChars[i] == pChars[j - 1] || pChars[j - 1] == '.'));
                }
            }
        }
        return dp[n][m];
    }
}
