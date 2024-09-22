class Solution {
    public int findKthNumber(int n, int k) {
        int cur = 1;
        k--;
        while (k > 0) {
            int c = count(cur, cur + 1, n);
            if (k >= c) {
                cur++;
                k -= c;
            } else {
                cur *= 10;
                k--;
            }
        }
        return cur;
    }

    private int count(long prefix1, long prefix2, int n) {
        int res = 0;
        while (prefix1 <= n) {
            res += Math.min(n + 1, prefix2) - prefix1;
            prefix1 *= 10;
            prefix2 *= 10;
        }
        return res;
    }
}
