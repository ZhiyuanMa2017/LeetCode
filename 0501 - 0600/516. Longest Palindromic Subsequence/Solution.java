class Solution {
    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int len = 0; len < n; len++) {
            for (int l = 0; l + len < n; l++) {
                int r = l + len;
                if (len == 0) {
                    dp[l][r] = 1;
                } else if (len == 1) {
                    if (s.charAt(l) == s.charAt(r)) {
                        dp[l][r] = 2;
                    } else {
                        dp[l][r] = 1;
                    }
                } else {
                    dp[l][r] = Math.max(dp[l + 1][r], dp[l][r - 1]);
                    if (s.charAt(l) == s.charAt(r)) {
                        dp[l][r] = Math.max(dp[l][r], dp[l + 1][r - 1] + 2);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
}
