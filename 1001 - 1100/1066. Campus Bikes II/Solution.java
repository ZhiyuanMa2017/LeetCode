import java.util.Arrays;

class Solution {
    int[] dp;

    public int assignBikes(int[][] workers, int[][] bikes) {
        int m = bikes.length;
        dp = new int[1 << m];
        Arrays.fill(dp, -1);
        return dfs(workers, bikes, 0, 0);
    }

    private int dfs(int[][] workers, int[][] bikes, int index, int mask) {
        if (index == workers.length) {
            return 0;
        }

        if (dp[mask] != -1) {
            return dp[mask];
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < bikes.length; i++) {
            if (((mask >> i) & 1) == 0) {
                int cur = cal(workers[index], bikes[i]);
                res = Math.min(res, cur + dfs(workers, bikes, index + 1, mask | 1 << i));
            }
        }
        return dp[mask] = res;
    }

    private int cal(int[] a, int[] b) {
        return Math.abs(a[0] - b[0]) + Math.abs(a[1] - b[1]);
    }
}
