class Solution {
    public long maxPoints(int[][] points) {
        int m = points.length;
        int n = points[0].length;
        long[] dp = new long[m];
        for (int j = 0; j < n; j++) {
            dp[j] = points[0][j];
        }
        for (int i = 1; i < m; i++) {
            long[] tmp = new long[m];
            long leftMax = 0;
            for (int j = 0; j < n; j++) {
                leftMax = Math.max(leftMax - 1, dp[j]);
                tmp[j] = leftMax;
            }
            long rightMax = 0;
            for (int j = n - 1; j >= 0; j--) {
                rightMax = Math.max(rightMax - 1, dp[j]);
                tmp[j] = Math.max(tmp[j], rightMax);
                tmp[j] += points[i][j];
            }
            dp = tmp;
        }
        long res = 0;
        for (int j = 0; j < n; j++) {
            res = Math.max(res, dp[j]);
        }
        return res;
    }
}
