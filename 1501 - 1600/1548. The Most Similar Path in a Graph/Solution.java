import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

class Solution {
    public List<Integer> mostSimilar(int n, int[][] roads, String[] names, String[] targetPath) {
        int m = targetPath.length;
        int[][] dp = new int[m][n];
        int[][] prev = new int[m][n];
        for (int i = 0; i < n; i++) {
            dp[0][i] = names[i].equals(targetPath[0]) ? 0 : 1;
        }
        for (int i = 1; i < m; i++) {
            Arrays.fill(dp[i], m + 1);
            for (int[] road : roads) {
                for (int j = 0; j < 2; j++) {
                    int from = road[j];
                    int to = road[1 - j];
                    int curDis = dp[i - 1][from] + (names[to].equals(targetPath[i]) ? 0 : 1);
                    if (curDis < dp[i][to]) {
                        dp[i][to] = curDis;
                        prev[i][to] = from;
                    }
                }
            }
        }
        int minDis = dp[m - 1][0];
        int minCity = 0;
        for (int i = 0; i < n; i++) {
            if (dp[m - 1][i] < minDis) {
                minDis = dp[m - 1][i];
                minCity = i;
            }
        }
        List<Integer> res = new ArrayList<>();
        res.add(minCity);
        for (int i = m - 1; i > 0; i--) {
            minCity = prev[i][minCity];
            res.add(minCity);
        }
        Collections.reverse(res);
        return res;
    }
}
