class Solution {
    public int minCost(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        int[] count;
        int importance;
        for (int i = 1; i <= n; i++) {
            count = new int[n];
            importance = 0;
            for (int j = i - 1; j >= 0; j--) {
                count[nums[j]]++;
                if (count[nums[j]] == 2) {
                    importance += 2;
                } else if (count[nums[j]] > 2) {
                    importance++;
                }
                dp[i] = Math.min(dp[i], dp[j] + importance + k);
            }
        }
        return dp[n];
    }
}
