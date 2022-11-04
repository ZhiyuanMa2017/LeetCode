class Solution {
    public int countGoodNumbers(long n) {
        return (int) (modPow(5, (n + 1) / 2) * modPow(4, n / 2) % (long) (1e9 + 7));
    }

    //0 1 2 3 4 5 6 7 8 9
    //even 0 2 4 6 8
    //prime 2 3 5 7
    private long modPow(long x, long n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        }
        long temp = x * x % (long) (1e9 + 7);
        if (n % 2 == 0) {
            return modPow(temp, n / 2);
        } else {
            return modPow(temp, (n - 1) / 2) * x % (long) (1e9 + 7);
        }
    }
}
