class Solution {
    public int arrangeCoins(int n) {
        long l = 1;
        long r = n;
        while (l < r) {
            long mid = l + (r - l + 1) / 2;
            if (mid * (mid + 1) / 2 <= n) {
                l = mid;
            } else {
                r = mid - 1;
            }
        }
        return (int) l;
    }
}
