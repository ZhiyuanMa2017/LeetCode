class Solution {
    public int computeArea(int ax1, int ay1, int ax2, int ay2, int bx1, int by1, int bx2, int by2) {
        int x1 = Math.max(ax1, bx1);
        int y1 = Math.max(ay1, by1);

        int x2 = Math.min(ax2, bx2);
        int y2 = Math.min(ay2, by2);
        int len1 = x2 - x1;
        int len2 = y2 - y1;
        int cover = 0;
        if (len1 > 0 && len2 > 0) {
            cover = len1 * len2;
        }
        int one = (ay2 - ay1) * (ax2 - ax1);
        int two = (by2 - by1) * (bx2 - bx1);
        return one + two - cover;
    }
}
