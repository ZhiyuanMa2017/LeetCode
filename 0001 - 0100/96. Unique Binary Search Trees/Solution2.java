class Solution2 {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int left = 0; left < i; left++) {
                dp[i] += dp[left] * dp[i - left - 1];
            }
        }
        return dp[n];
    }
}
