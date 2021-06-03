import java.util.Arrays;

class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        long hm = 0;
        long wm = 0;
        long hp = 0;
        long wp = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int hc : horizontalCuts) {
            hm = Math.max(hm, hc - hp);
            hp = hc;
        }
        hm = Math.max(hm, h - hp);
        for (int vc : verticalCuts) {
            wm = Math.max(wm, vc - wp);
            wp = vc;
        }
        wm = Math.max(wm, w - wp);
        return (int) ((hm * wm) % (Math.pow(10, 9) + 7));
    }
}
