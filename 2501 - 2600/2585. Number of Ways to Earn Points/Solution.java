class Solution {
    public int waysToReachTarget(int target, int[][] types) {
        int mod = (int) (1e9 + 7);
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int[] type : types) {
            int count = type[0];
            int mark = type[1];
            for (int i = target - 1; i >= 0; i--) {
                for (int j = count; j >= 1; j--) {
                    int cur = i + j * mark;
                    if (cur <= target) {
                        dp[cur] = (dp[cur] + dp[i]) % mod;
                    }
                }
            }
        }
        return dp[target];
    }
}
