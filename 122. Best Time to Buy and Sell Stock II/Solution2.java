class Solution2 {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int notBuy = 0;
        int newBuy = 0;
        int newNotBuy = 0;
        for (int i = 1; i < prices.length; i++) {
            newBuy = Math.max(buy, notBuy - prices[i]);
            newNotBuy = Math.max(notBuy, buy + prices[i]);
            buy = newBuy;
            notBuy = newNotBuy;
        }
        return Math.max(buy, notBuy);
    }
}
