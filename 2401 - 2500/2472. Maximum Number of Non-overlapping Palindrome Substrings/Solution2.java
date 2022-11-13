class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        boolean[][] p = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            p[i][i] = true;
        }
        for (int i = 0; i < n - 1; i++) {
            if (chars[i] == chars[i + 1]) {
                p[i][i + 1] = true;
            }
        }
        for (int len = 3; len <= k + 1; len++) {
            int i = 0;
            int j = i + len - 1;
            while (j < n) {
                if (p[i + 1][j - 1] && chars[i] == chars[j]) {
                    p[i][j] = true;
                }
                i++;
                j++;
            }
        }

        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int end = i - 1;
            int start = end - (k - 1);
            int start2 = end - k;
            if (start >= 0 && p[start][end]) {
                dp[i] = Math.max(dp[i], dp[start + 1] + 1);
            }
            if (start2 >= 0 && p[start2][end]) {
                dp[i] = Math.max(dp[i], dp[start2 + 1] + 1);
            }
        }
        return dp[n];
    }
}
