class Solution {
    public int longestArithSeqLength(int[] nums) {
        int res = 2;
        int n = nums.length;
        int[][] dp = new int[n][1001];
        for (int i = 0; i < n; i++) {
            for (int j = i - 1; j >= 0; j--) {
                int diff = nums[i] - nums[j];
                if (dp[i][diff + 500] > 0) {
                    continue;
                }
                dp[i][diff + 500] = dp[j][diff + 500] == 0 ? 2 : dp[j][diff + 500] + 1;
                res = Math.max(res, dp[i][diff + 500]);
            }
        }
        return res;
    }
}
