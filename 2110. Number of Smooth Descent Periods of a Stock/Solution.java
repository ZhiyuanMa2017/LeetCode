class Solution {
    public long getDescentPeriods(int[] prices) {
        long res = prices.length;
        if (res <= 1) {
            return res;
        }
        long len = 1;
        long count = 0;

        for (int i = 0; i < prices.length; i++) {
            if (i == 0) {
                continue;
            }
            if (prices[i] == prices[i - 1] - 1) {
                count += len;
                len++;
            } else {
                res += count;
                count = 0;
                len = 1;
            }
        }
        if (prices[prices.length - 1] == prices[prices.length - 2] - 1) {
            res += count;
        }
        return res;
    }
}
