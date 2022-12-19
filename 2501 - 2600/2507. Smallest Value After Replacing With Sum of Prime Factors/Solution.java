class Solution {
    public int smallestValue(int n) {
        while (true) {
            int prev = n;
            int sum = 0;
            for (int i = 2; i * i <= n; i++) {
                while (n % i == 0) {
                    n /= i;
                    sum += i;
                }
            }
            if (n != 1) {
                sum += n;
            }
            n = sum;
            if (n == prev) {
                return prev;
            }
        }
    }
}
