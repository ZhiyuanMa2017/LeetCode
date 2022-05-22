import java.util.Arrays;

class Solution {
    public int minimumLines(int[][] stockPrices) {
        if (stockPrices.length == 1) {
            return 0;
        }
        Arrays.sort(stockPrices, (a, b) -> a[0] - b[0]);
        int res = 1;
        for (int i = 0; i < stockPrices.length - 2; i++) {
            long day1 = stockPrices[i][0];
            long price1 = stockPrices[i][1];
            long day2 = stockPrices[i + 1][0];
            long price2 = stockPrices[i + 1][1];
            long day3 = stockPrices[i + 2][0];
            long price3 = stockPrices[i + 2][1];
            if ((price3 - price2) * (day2 - day1) == (price2 - price1) * (day3 - day2)) {
                continue;
            } else {
                res++;
            }
        }
        return res;
    }
}
