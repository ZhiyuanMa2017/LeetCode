class Solution {
    public int monkeyMove(int n) {
        int mod = 1000000007;
        long res = binPow(2, n, mod);
        return (int) (res - 2 + mod) % mod;
    }

    long binPow(long a, long b, long m) {
        a %= m;
        long res = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * a % m;
            }
            a = a * a % m;
            b >>= 1;
        }
        return res;
    }
}
