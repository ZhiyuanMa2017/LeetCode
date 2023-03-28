class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        int n = days.length;
        int[] dp = new int[366];
        int index = 0;
        for (int i = 1; i < 366; i++) {
            if (index < n) {
                if (days[index] != i) {
                    dp[i] = dp[i - 1];
                } else {
                    int one = dp[i - 1] + costs[0];
                    int seven = i - 7 >= 0 ? dp[i - 7] + costs[1] : costs[1];
                    int thirty = i - 30 >= 0 ? dp[i - 30] + costs[2] : costs[2];
                    dp[i] = Math.min(one, Math.min(seven, thirty));
                    index++;
                }
            } else {
                break;
            }
        }
        return dp[days[n - 1]];
    }
}
