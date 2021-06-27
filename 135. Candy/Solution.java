import java.util.Arrays;

class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if (n == 1) {
            return 1;
        }
        int[] candy = new int[n];
        Arrays.fill(candy, 1);
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                candy[i] = candy[i - 1] + 1;
            }
        }
        for (int i = n - 1; i > 0; i--) {
            if (ratings[i] < ratings[i - 1]) {
                candy[i - 1] = Math.max(candy[i - 1], candy[i] + 1);
            }
        }
        int res = 0;
        for (int c : candy) {
            res += c;
        }
        return res;
    }
}
