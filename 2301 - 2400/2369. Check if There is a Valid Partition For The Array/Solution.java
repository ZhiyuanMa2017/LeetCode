class Solution {
    public boolean validPartition(int[] nums) {
        int n = nums.length;
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        for (int i = 0; i < n; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                if (dp[i + 1 - 2]) {
                    dp[i + 1] = true;
                }
            }
            if (i >= 2 && nums[i] == nums[i - 1] && nums[i - 1] == nums[i - 2]) {
                if (dp[i + 1 - 3]) {
                    dp[i + 1] = true;
                }
            }
            if (i >= 2 && nums[i] == nums[i - 1] + 1 && nums[i - 1] == nums[i - 2] + 1) {
                if (dp[i + 1 - 3]) {
                    dp[i + 1] = true;
                }
            }
        }
        return dp[n];
    }
}
