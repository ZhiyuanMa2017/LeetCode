import java.util.List;

// https://leetcode.com/discuss/interview-question/374446/Twitter-or-OA-2019-or-Efficient-Job-Processing-Service
class Solution {
    public static int processCandidates(List<Integer> tasks, List<Integer> weights, int p) {
        int n = tasks.size();
        int[] taskArray = new int[n];
        for (int i = 0; i < n; i++) {
            taskArray[i] = 2 * tasks.get(i);
        }
        int[][] dp = new int[n][p + 1];
        for (int i = 0; i <= p; i++) {
            dp[0][i] = taskArray[0] > i ? 0 : weights.get(0);
        }
        for (int i = 1; i < n; i++) {
            for (int j = 0; j <= p; j++) {
                if (taskArray[i] > j) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], weights.get(i) + dp[i - 1][j - taskArray[i]]);
                }
            }
        }
        return dp[n - 1][p];
    }
}
