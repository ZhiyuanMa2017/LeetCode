class Solution {
    public int consecutiveNumbersSum(int n) {
        int res = 1;
        int count;
        while (n % 2 == 0) {
            n /= 2;
        }
        for (int i = 3; i * i <= n; i += 2) {
            count = 0;
            while (n % i == 0) {
                n /= i;
                count++;
            }
            res *= count + 1;
        }
        if (n == 1) {
            return res;
        } else {
            return res * (1 + 1);
        }
    }
}
