class Solution2 {
    public int mySqrt(int x) {
        if (x <= 1) {
            return x;
        }
        int l = 1;
        int h = x / 2;
        while (l < h) {
            int mid = l + (h - l + 1) / 2;
            if (mid <= x / mid) {
                l = mid;
            } else {
                h = mid - 1;
            }
        }
        return l;
    }
}
