class Solution {
    public int deleteString(String s) {
        int n = s.length();
        int[][] lcs = new int[n + 1][n + 1];
        // longest common substring
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcs[i][j] = lcs[i + 1][j + 1] + 1;
                }
            }
        }
        int[] dp = new int[n];
        for (int i = n - 1; i >= 0; i--) {
            dp[i] = 1;
            for (int len = 1; i + len * 2 <= n; len++) {
                if (lcs[i][i + len] >= len) {
                    dp[i] = Math.max(dp[i], dp[i + len] + 1);
                }
            }
        }
        return dp[0];
    }
}
