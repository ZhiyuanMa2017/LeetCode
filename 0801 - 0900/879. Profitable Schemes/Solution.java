class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        long[][] dp = new long[n + 1][minProfit + 1];
        int mod = (int) (1e9 + 7);
        dp[0][0] = 1;
        for (int i = 0; i < group.length; i++) {
            int g = group[i];
            int p = profit[i];
            for (int prevG = n - g; prevG >= 0; prevG--) {
                for (int prevP = minProfit; prevP >= 0; prevP--) {
                    int curG = prevG + g;
                    int curP = prevP + p;
                    dp[curG][Math.min(curP, minProfit)] = (dp[curG][Math.min(curP, minProfit)] + dp[prevG][prevP]) % mod;
                }
            }
        }
        long res = 0;
        for (int i = 0; i <= n; i++) {
            res = (res + dp[i][minProfit]) % mod;
        }
        return (int) res;
    }
}
