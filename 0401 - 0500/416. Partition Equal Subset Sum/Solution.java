class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        int maxnum = 0;
        for (int j : nums) {
            sum += j;
            maxnum = Math.max(maxnum, j);
        }
        if (sum % 2 != 0 || sum - maxnum < maxnum) {
            return false;
        }
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];
    }
}