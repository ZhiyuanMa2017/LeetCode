class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid[0].length;
        int[] dp = new int[n];
        dp[0] = 1;
        for (int[] rows : obstacleGrid) {
            for (int i = 0; i < n; i++) {
                if (rows[i] == 1) {
                    dp[i] = 0;
                    continue;
                }
                if (i > 0) {
                    dp[i] += dp[i - 1];
                }
            }
        }
        return dp[n - 1];
    }
}
