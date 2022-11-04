import java.util.List;

class Solution {
    public int maxValueOfCoins(List<List<Integer>> piles, int k) {
        int[] preSum = new int[2002];
        int[] dp = new int[2002];
        for (List<Integer> pile : piles) {
            int n = pile.size();
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + pile.get(i);
            }
            for (int i = k; i > 0; i--) {
                for (int j = 1; j <= Math.min(i, n); j++) {
                    dp[i] = Math.max(dp[i], dp[i - k] + preSum[j]);
                }
            }
        }
        return dp[k];
    }
}
