class Solution {
    public int numWays(String[] words, String target) {
        int m = words[0].length();
        int n = target.length();
        int[][] count = new int[m][26];
        for (int i = 0; i < m; i++) {
            for (String word : words) {
                count[i][word.charAt(i) - 'a']++;
            }
        }
        long[][] dp = new long[m][n];
        int mod = (int) (1e9 + 7);
        dp[0][0] = count[0][target.charAt(0) - 'a'] % mod;
        for (int i = 1; i < m; i++) {
            dp[i][0] = (dp[i - 1][0] + count[i][target.charAt(0) - 'a'] % mod);
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j];
                dp[i][j] = (dp[i][j] + dp[i - 1][j - 1] * count[i][target.charAt(j) - 'a'] % mod) % mod;
            }
        }
        return (int) dp[m - 1][n - 1];
    }
}
