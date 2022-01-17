class Solution {
    public static int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 0;
        int h = x;
        while (l <= h) {
            int mid = l + (h - l) / 2;

            if (mid == x / mid) {
                return mid;
            } else if (mid > x / mid) {
                h = mid - 1;
            } else if (mid < x / mid) {
                l = mid + 1;
            }
        }
        return h;
    }
}
