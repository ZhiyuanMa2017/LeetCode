class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        int inf = 10000000;
        int[][][] dp = new int[m + 1][n + 1][target + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j][0] = inf;
            }
        }
        for (int i = 1; i <= m; i++) {
            int color = houses[i - 1];
            for (int j = 1; j <= n; j++) {
                for (int k = 1; k <= target; k++) {
                    if (k > i) {
                        dp[i][j][k] = inf;
                        continue;
                    }
                    if (color != 0) {
                        if (j == color) {
                            int tmp = inf;
                            for (int previousColor = 1; previousColor <= n; previousColor++) {
                                if (previousColor != j) {
                                    tmp = Math.min(tmp, dp[i - 1][previousColor][k - 1]);
                                }
                            }
                            dp[i][j][k] = Math.min(dp[i - 1][j][k], tmp);
                        } else {
                            dp[i][j][k] = inf;
                        }
                    } else {
                        int curCost = cost[i - 1][j - 1];
                        int tmp = inf;
                        for (int previousColor = 1; previousColor <= n; previousColor++) {
                            if (previousColor != j) {
                                tmp = Math.min(tmp, dp[i - 1][previousColor][k - 1]);
                            }
                        }
                        dp[i][j][k] = Math.min(dp[i - 1][j][k], tmp) + curCost;
                    }
                }
            }
        }
        int res = inf;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dp[m][i][target]);
            System.out.println(dp[m][i][target]);
        }
        return res == inf ? -1 : res;
    }
}
