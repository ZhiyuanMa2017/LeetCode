class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        // dp[i][j] means how much more first player can get
        for (int i = 0; i < n; i++) {
            dp[i][i] = nums[i];
        }
        for (int j = 1; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);

            }
        }
        return dp[0][n - 1] > 0;
    }
}
