class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        int a = dividend > 0 ? -dividend : dividend;
        int b = divisor > 0 ? -divisor : divisor;
        while (a <= b) {
            int tmp = b;
            int count = -1;
            while (a - tmp <= tmp) {
                tmp += tmp;
                count += count;
            }
            a -= tmp;
            res += count;
        }
        return (dividend >= 0) != (divisor >= 0) ? res : -res;
    }
}
