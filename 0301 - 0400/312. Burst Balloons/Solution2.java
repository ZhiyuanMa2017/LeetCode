class Solution2 {
    public int maxCoins(int[] nums) {
        int len = nums.length;
        int n = len + 2;
        int[] arr = new int[n];
        arr[0] = 1;
        int index = 1;
        for (int num : nums) {
            arr[index] = num;
            index++;
        }
        arr[n - 1] = 1;
        int[][] dp = new int[n][n];
        for (int gap = 2; gap < n; gap++) {
            for (int left = 0; left < n - gap; left++) {
                int right = left + gap;
                for (int i = left + 1; i < right; i++) {
                    dp[left][right] = Math.max(dp[left][right],
                            arr[left] * arr[i] * arr[right] + dp[left][i] + dp[i][right]);
                }
            }
        }
        return dp[0][n - 1];
    }
}
