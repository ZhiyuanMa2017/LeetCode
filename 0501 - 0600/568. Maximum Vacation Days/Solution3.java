import java.util.Arrays;

class Solution3 {
    public int maxVacationDays(int[][] flights, int[][] days) {
        int n = flights.length;
        int k = days[0].length;
        int[][] dp = new int[n][k];
        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], Integer.MIN_VALUE);
            if (i == 0 || flights[0][i] == 1) {
                dp[i][0] = days[i][0];
            }
        }
        for (int week = 1; week < k; week++) {
            for (int from = 0; from < n; from++) {
                for (int next = 0; next < n; next++) {
                    if (from == next || flights[from][next] == 1) {
                        dp[next][week] = Math.max(dp[next][week], dp[from][week - 1] + days[next][week]);
                    }
                }
            }
        }
        int res = 0;
        for (int i = 0; i < n; i++) {
            res = Math.max(dp[i][k - 1], res);
        }
        return res;
    }
}
