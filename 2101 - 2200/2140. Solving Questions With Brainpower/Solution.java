class Solution {
    public long mostPoints(int[][] questions) {
        int n = questions.length;
        long[] dp = new long[questions.length];
        long cur = 0;
        long last = 0;
        for (int i = 0; i < questions.length; i++) {
            dp[i] = Math.max(dp[i], cur);
            int index = i + questions[i][1] + 1;
            if (index < n) {
                dp[index] = Math.max(dp[index], dp[i] + questions[i][0]);
            } else {
                last = Math.max(last, dp[i] + questions[i][0]);
            }

            cur = Math.max(dp[i], cur);
        }
        return last;
    }
}
