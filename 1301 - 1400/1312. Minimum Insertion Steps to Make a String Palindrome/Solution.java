class Solution {
    public int minInsertions(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            if (i + 1 < n) {
                if (s.charAt(i) == s.charAt(i + 1)) {
                    dp[i][i + 1] = 2;
                } else {
                    dp[i][i + 1] = 1;
                }
            }
        }
        for (int len = 2; len < n; len++) {
            for (int left = 0; left + len < n; left++) {
                int right = left + len;
                dp[left][right] = Math.max(dp[left + 1][right], dp[left][right - 1]);
                if (s.charAt(left) == s.charAt(right)) {
                    dp[left][right] = Math.max(dp[left][right], dp[left + 1][right - 1] + 2);
                }
            }
        }
        return n - dp[0][n - 1];
    }
}
