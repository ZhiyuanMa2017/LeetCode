class Solution {
    public int countHousePlacements(int n) {
        int mod = 1000000007;
        if (n == 1) {
            return 2 * 2;
        }
        if (n == 2) {
            return 3 * 3;
        }
        long prev = 2;
        long cur = 3;
        for (int i = 0; i < n - 2; i++) {
            long tmp = (cur + prev) % mod;
            prev = cur;
            cur = tmp;
        }
        return (int) ((cur * cur) % mod);
    }
}
