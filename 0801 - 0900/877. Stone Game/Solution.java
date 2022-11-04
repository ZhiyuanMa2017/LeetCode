class Solution {
    public boolean stoneGame(int[] piles) {
        int n = piles.length;
        // dp[i][j]: between first take - second take
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[i][i] = piles[i];
        }
        for (int step = 1; step < n; step++) {
            for (int i = 0; i + step < n; i++) {
                dp[i][i + step] = Math.max(piles[i] - dp[i + 1][i + step], piles[i + step] - dp[i][i + step - 1]);
                System.out.println(i + " " + (i + step) + " | " + (i + 1) + " " + (i + step) + " | " + i + " " + (i + step - 1));
            }
        }
        return dp[0][n - 1] > 0;
    }

    public static void main(String[] args) {
        new Solution().stoneGame(new int[]{5, 3, 4, 5});
    }
}
