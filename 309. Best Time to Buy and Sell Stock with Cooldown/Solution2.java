class Solution2 {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int sell = 0;
        int cooldown = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, cooldown - prices[i]);
            cooldown = Math.max(cooldown, sell);
            sell = Math.max(sell, buy + prices[i]);
        }
        return Math.max(cooldown, sell);
    }
}
