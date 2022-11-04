class Solution {
    public int maxProfit(int[] prices, int fee) {
        int buy = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            int lastbuy = buy;
            int lastsell = sell;
            buy = Math.max(lastbuy, lastsell - prices[i]);
            // first argument: not buy, second: buy
            sell = Math.max(lastsell, lastbuy + prices[i] - fee);
            // first argument: not sell, second: sell
        }
        return sell;
    }
}
