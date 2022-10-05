class Solution {
    public int ways(String[] pizza, int k) {
        int m = pizza.length;
        int n = pizza[0].length();
        int[][] suffixSum = new int[m + 1][n + 1];
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                suffixSum[i][j] = suffixSum[i + 1][j] + suffixSum[i][j + 1] - suffixSum[i + 1][j + 1];
                if (pizza[i].charAt(j) == 'A') {
                    suffixSum[i][j]++;
                }
            }
        }
        Integer[][][] dp = new Integer[m][n][k];
        return dfs(m, n, dp, suffixSum, 0, 0, k);
    }

    private int dfs(int m, int n, Integer[][][] dp, int[][] suffixSum, int startRow, int startCol, int k) {
        if (suffixSum[startRow][startCol] == 0) {
            return 0;
        }
        if (suffixSum[startRow][startCol] < k) {
            return 0;
        }
        if (k == 1) {
            return 1;
        }
        if (dp[startRow][startCol][k - 1] != null) {
            return dp[startRow][startCol][k - 1];
        }
        int res = 0;
        int mod = 1000000007;
        for (int x = startRow + 1; x < m; x++) {
            if (suffixSum[startRow][startCol] - suffixSum[x][startCol] > 0) {
                res = (res + dfs(m, n, dp, suffixSum, x, startCol, k - 1)) % mod;
            }
        }
        for (int y = startCol + 1; y < n; y++) {
            if (suffixSum[startRow][startCol] - suffixSum[startRow][y] > 0) {
                res = (res + dfs(m, n, dp, suffixSum, startRow, y, k - 1)) % mod;
            }
        }
        dp[startRow][startCol][k - 1] = res;
        return res;
    }
}
