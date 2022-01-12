class Solution {
    public int maxProfit(int[] prices) {
        int buy = -prices[0];
        int notBuy = 0;
        for (int i = 1; i < prices.length; i++) {
            buy = Math.max(buy, notBuy - prices[i]);
            notBuy = Math.max(notBuy, buy + prices[i]);
        }
        return notBuy;
    }
}
