class Solution {
    public int maxProfit(int[] prices) {
        int[] dp1 = new int[prices.length];
        int[] dp2 = new int[prices.length];
        int[] dp3 = new int[prices.length];

        dp1[0] = -prices[0]; // has stock
        dp2[0] = 0; // do not have stock, sell them today
        dp3[0] = 0; // do not have stock, sell them before today
        for (int i = 1; i < prices.length; i++) {
            dp1[i] = Math.max(dp1[i - 1], dp3[i - 1] - prices[i]);
            dp2[i] = dp1[i - 1] + prices[i];
            dp3[i] = Math.max(dp2[i - 1], dp3[i - 1]);
        }
        return Math.max(dp2[prices.length - 1], dp3[prices.length - 1]);
    }
}
