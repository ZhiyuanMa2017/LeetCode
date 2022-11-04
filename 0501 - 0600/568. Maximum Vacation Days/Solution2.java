public class Solution2 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k + 1];
        for (int i = k - 1; i >= 0; i--) {
            for (int city = 0; city < n; city++) {
                dp[city][i] = days[city][i] + dp[city][i + 1];
                for (int next = 0; next < n; next++) {
                    if (flights[city][next] == 1) {
                        dp[city][i] = Math.max(dp[city][i], days[next][i] + dp[next][i + 1]);
                    }
                }
            }
        }
        return dp[0][0];
    }
}
