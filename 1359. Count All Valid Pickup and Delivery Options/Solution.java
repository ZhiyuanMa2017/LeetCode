class Solution {
    public int countOrders(int n) {
        int mod = 1000000007;
        long res = 1;
        for (int i = 1; i <= n; i++) {
            long pos = 2L * (i - 1) + 1;
            long cur = pos * (pos + 1) / 2 % mod;
            res = res * cur % mod;
        }
        return (int) res % mod;
    }
}
