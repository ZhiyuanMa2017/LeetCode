class Solution {
    public int numRollsToTarget(int n, int k, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int mod = 1000000007;
        for (int i = 0; i < n; i++) {
            int[] tmp = new int[target + 1];
            for (int j = 1; j <= target; j++) {
                for (int p = 1; p <= k; p++) {
                    if (j >= p) {
                        tmp[j] = (tmp[j] + dp[j - p]) % mod;
                    } else {
                        break;
                    }
                }
            }
            dp = tmp;
        }
        return dp[target];
    }
}
