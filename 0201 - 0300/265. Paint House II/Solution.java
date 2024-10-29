class Solution {
    public int minCostII(int[][] costs) {
        int n = costs.length;
        int k = costs[0].length;
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < k; j++) {
                int min = Integer.MAX_VALUE;
                for (int p = 0; p < k; p++) {
                    if (p == j) {
                        continue;
                    }
                    min = Math.min(min, costs[i - 1][p]);
                }
                costs[i][j] += min;
            }
        }
        int res = Integer.MAX_VALUE;
        for (int j = 0; j < k; j++) {
            res = Math.min(res, costs[n - 1][j]);
        }
        return res;
    }
}
