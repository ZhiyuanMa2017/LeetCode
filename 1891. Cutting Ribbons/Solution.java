class Solution {
    public int maxLength(int[] ribbons, int k) {
        int l = 0;
        int h = 100000;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (!check(ribbons, k, mid)) {
                h = mid - 1;
            } else {
                l = mid;
            }
        }
        return l;
    }

    private boolean check(int[] ribbons, int k, int length) {
        int cur = 0;
        for (int ribbon : ribbons) {
            cur += ribbon / length;
        }
        return cur >= k;
    }
}
