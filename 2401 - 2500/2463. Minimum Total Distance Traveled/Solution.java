import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;
        Collections.sort(robot);
        Arrays.sort(factory, (a, b) -> a[0] - b[0]);
        long[][] dp = new long[m][n + 1];
        for (int i = 0; i < m; i++) {
            Arrays.fill(dp[i], Long.MAX_VALUE);
            dp[i][0] = 0;
        }
        for (int j = 1; j <= Math.min(factory[0][1], n); j++) {
            dp[0][j] = dp[0][j - 1] + Math.abs(factory[0][0] - robot.get(j - 1));
        }
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n; j++) {
                if (dp[i][j] == Long.MAX_VALUE) {
                    break;
                }
                dp[i + 1][j] = Math.min(dp[i + 1][j], dp[i][j]);
                long cur = 0;
                for (int k = 1; k <= factory[i + 1][1]; k++) {
                    if (j + k > n) {
                        break;
                    }
                    cur += Math.abs(factory[i + 1][0] - robot.get(j + k - 1));
                    dp[i + 1][j + k] = Math.min(dp[i + 1][j + k], dp[i][j] + cur);
                }
            }
        }
        long res = Long.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            res = Math.min(res, dp[i][n]);
        }
        return res;
    }
}
