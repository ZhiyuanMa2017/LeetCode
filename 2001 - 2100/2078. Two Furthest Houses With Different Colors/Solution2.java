class Solution2 {
    public int maxDistance(int[] colors) {
        int res = 0;
        int i = 0;
        while (i < colors.length - 1 && colors[i] == colors[colors.length - 1]) {
            i++;
        }
        res = colors.length - 1 - i;
        i = colors.length - 1;
        while (i > 0 && colors[i] == colors[0]) {
            i--;
        }
        res = Math.max(res, i);
        return res;
    }
}
