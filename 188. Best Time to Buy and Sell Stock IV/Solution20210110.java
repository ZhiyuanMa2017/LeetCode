import java.util.Arrays;

class Solution {
    public int maxProfit(int k, int[] prices) {
        if (k == 0 || prices.length == 0) {
            return 0;
        }
        int[] buy = new int[k];
        int[] sell = new int[k];
        Arrays.fill(buy, Integer.MIN_VALUE);
        for (int i = 0; i < prices.length; i++) {
            buy[0] = Math.max(buy[0], -prices[i]);
            sell[0] = Math.max(sell[0], buy[0] + prices[i]);
            for (int j = 1; j < k; j++) {
                buy[j] = Math.max(buy[j], sell[j - 1] - prices[i]);
                sell[j] = Math.max(sell[j], buy[j] + prices[i]);
            }
        }
        return sell[k - 1];

    }
}
