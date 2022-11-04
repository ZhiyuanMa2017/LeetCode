class Solution2 {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0] - fee;
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, sell - prices[i] - fee);
            sell = Math.max(sell, buy + prices[i]);
        }
        return sell;
    }
}
