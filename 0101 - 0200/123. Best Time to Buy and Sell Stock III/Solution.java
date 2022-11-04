class Solution {
    public int maxProfit(int[] prices) {
        int buyOne = -prices[0];
        int sellOne = 0;
        int buyTwo = Integer.MIN_VALUE;
        int sellTwo = 0;
        for (int i = 1; i < prices.length; i++) {
            buyOne = Math.max(buyOne, -prices[i]);
            sellOne = Math.max(sellOne, buyOne + prices[i]);
            buyTwo = Math.max(buyTwo, sellOne - prices[i]);
            sellTwo = Math.max(sellTwo, buyTwo + prices[i]);
        }
        return sellTwo;
    }
}
