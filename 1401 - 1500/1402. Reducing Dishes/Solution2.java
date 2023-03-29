import java.util.Arrays;

class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        int n = satisfaction.length;
        Arrays.sort(satisfaction);
        int[][] dp = new int[n][n + 1];
        dp[0][1] = satisfaction[0];
        for (int i = 1; i < n; i++) {
            int ss = satisfaction[i];
            for (int j = 1; j < i + 1; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], ss * j + dp[i - 1][j - 1]);
            }
            dp[i][i + 1] = ss * (i + 1) + dp[i - 1][i];
        }
        int res = 0;
        for (int i = 1; i <= n; i++) {
            res = Math.max(res, dp[n - 1][i]);
        }
        return res;
    }
}
