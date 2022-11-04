class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        int res = 0;
        int a = Math.abs(dividend);
        int b = Math.abs(divisor);
        while (a - b >= 0) {
            int tmp = b;
            int count = 1;
            while (a - (tmp << 1) >= 0) {
                tmp <<= 1;
                count <<= 1;
            }
            a -= tmp;
            res += count;
        }
        return (dividend >= 0) == (divisor >= 0) ? res : -res;
    }
}
