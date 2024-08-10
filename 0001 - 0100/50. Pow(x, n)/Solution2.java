class Solution2 {
    public double myPow(double x, int n) {
        double res = 1;
        if (n < 0) {
            // Integer.MIN_VALUE -2147483648
            // -Integer.MIN_VALUE
            res = 1 / x;
            x = 1 / x;
            n = -(n + 1);
        }
        while (n > 0) {
            if ((n & 1) == 1) {
                res *= x;
            }
            x *= x;
            n >>= 1;
        }
        return res;
    }
}
