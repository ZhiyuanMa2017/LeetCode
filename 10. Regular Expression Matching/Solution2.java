class Solution2 {
    public boolean isMatch(String s, String p) {
        int n = s.length();
        int m = p.length();
        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;
        String ss = " " + s;
        String pp = " " + p;
        char[] source = ss.toCharArray();
        char[] pattern = pp.toCharArray();
        for (int i = 0; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                // case 1: match, so just check previous status(i-1 vs j-1)
                if (pattern[j] == '.' || pattern[j] == source[i]) {
                    dp[i][j] = i >= 1 && dp[i - 1][j - 1];
                }
                // case 2: *
                if (pattern[j] == '*') {
                    // case 2.1: 0 match, so just check j - 2
                    // pattern: something(alphabet)* no match, so ignore this two, return j - 2
                    if (j >= 2) {
                        dp[i][j] = dp[i][j - 2];
                    }
                    // case 2.2: 1 or more matches
                    // pattern: (alphabet)*
                    // source: THING something
                    // so here check something == alphabet, and return previous status (i-1 vs j)
                    // cause matches 1 or more, so check THING matches pattern or not
                    // example: pattern: abcd*     source: abcdd
                    // find abcd ? -> find abc ?
                    // abc TRUE -> abcd TRUE -> abcdd TRUE
                    if (i >= 1) {
                        dp[i][j] = dp[i][j] || (source[i] == pattern[j - 1] || pattern[j - 1] == '.') && dp[i - 1][j];
                    }
                }
            }
        }
        return dp[n][m];
    }
}
