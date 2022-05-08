class Solution {
    public int countTexts(String pressedKeys) {
        int mod = 1000000007;
        int n = pressedKeys.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        for (int i = 1; i < n + 1; i++) {
            char c = pressedKeys.charAt(i - 1);
            int max;
            if (c == '7' || c == '9') {
                max = 4;
            } else {
                max = 3;
            }
            dp[i] = dp[i - 1];
            for (int j = 2; j <= max; j++) {
                if (i - j >= 0 && pressedKeys.charAt(i - j) == pressedKeys.charAt(i - 1)) {
                    dp[i] = (dp[i] + dp[i - j]) % mod;
                } else {
                    break;
                }
            }
        }
        return dp[n];
    }
}
