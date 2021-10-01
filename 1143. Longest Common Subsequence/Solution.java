class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        if (m < n) {
            return longestCommonSubsequence(text2, text1);
        }
        int[][] dp = new int[2][n + 1];
        for (int i = 0, k = 1; i < m; i++, k ^= 1) {
            for (int j = 0; j < n; j++) {
                if (text1.charAt(i) == text2.charAt(j)) {
                    dp[k][j + 1] = 1 + dp[k ^ 1][j];
                } else {
                    dp[k][j + 1] = Math.max(dp[k ^ 1][j + 1], dp[k][j]);
                }
            }
        }
        return dp[m % 2][n];
    }
}
