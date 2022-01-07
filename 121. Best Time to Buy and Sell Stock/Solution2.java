class Solution2 {
    public int maxProfit(int[] prices) {
        int curMax = 0;
        int res = 0;
        for (int i = 1; i < prices.length; i++) {
            curMax += prices[i] - prices[i - 1];
            if (curMax > res) {
                res = curMax;
            } else if (curMax < 0) {
                curMax = 0;
            }
        }
        return res;
    }
}
