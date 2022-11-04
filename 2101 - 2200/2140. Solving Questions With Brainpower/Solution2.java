class Solution2 {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[questions.length];
        dp[n - 1] = questions[n - 1][0];
        for (int i = n - 2; i >= 0; i--) {
            int index = i + 1 + questions[i][1];
            if (index < n) {
                dp[i] = Math.max(dp[i + 1], dp[index] + questions[i][0]);
            } else {
                dp[i] = Math.max(dp[i + 1], questions[i][0]);
            }
        }
        return dp[0];
    }
}
