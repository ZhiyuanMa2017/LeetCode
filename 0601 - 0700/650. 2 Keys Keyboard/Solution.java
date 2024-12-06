import java.util.Arrays;

class Solution {
    public int minSteps(int n) {
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[1] = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                if (i % j == 0) {
                    dp[i] = Math.min(dp[i], dp[j] + i / j);
                }
            }
        }
        return dp[n];
    }
}
