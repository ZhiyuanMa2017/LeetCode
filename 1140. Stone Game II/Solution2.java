class Solution2 {
    int[][] memo;
    int[] suffixSum;

    public int stoneGameII(int[] piles) {
        suffixSum = new int[piles.length];
        suffixSum[piles.length - 1] = piles[piles.length - 1];
        for (int i = piles.length - 2; i >= 0; i--) {
            suffixSum[i] = suffixSum[i + 1] + piles[i];
        }
        memo = new int[piles.length][piles.length];
        return dfs(1, 0);
    }

    private int dfs(int m, int begin) {
        if (begin + 2 * m >= suffixSum.length) {
            return suffixSum[begin];
        }
        if (memo[begin][m] > 0) {
            return memo[begin][m];
        }
        int res = 0;
        for (int x = 1; x <= 2 * m; x++) {
            res = Math.max(res, suffixSum[begin] - dfs(Math.max(x, m), begin + x));
        }
        memo[begin][m] = res;
        return res;
    }
}
