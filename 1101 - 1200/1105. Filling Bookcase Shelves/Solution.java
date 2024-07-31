class Solution {
    public int minHeightShelves(int[][] books, int shelfWidth) {
        int n = books.length;
        int[] dp = new int[n + 1];
        for (int i = 0; i < n; i++) {
            dp[i + 1] = 100001;
            int h = 0;
            int w = shelfWidth;
            for (int j = i; j >= 0; j--) {
                w -= books[j][0];
                if (w < 0) {
                    break;
                }
                h = Math.max(h, books[j][1]);
                dp[i + 1] = Math.min(dp[i + 1], dp[j] + h);

            }
        }
        return dp[n];
    }
}
