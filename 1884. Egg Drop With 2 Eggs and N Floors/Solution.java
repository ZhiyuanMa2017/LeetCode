class Solution {
    public int twoEggDrop(int n) {
        int[] dp = new int[46];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2; i < 46; i++) {
            dp[i] = dp[i - 1] + i;
        }
        for (int i = 0; i < 46; i++) {
            if (dp[i] > n) {
                return i;
            }
        }
        return -1;
    }
}
