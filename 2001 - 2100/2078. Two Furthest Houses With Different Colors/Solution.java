class Solution {
    public int maxDistance(int[] colors) {
        int res = 0;
        int n = colors.length;
        for (int i = 0; i < n; i++) {
            int j = n - 1 - i;
            if (colors[0] != colors[j] || colors[i] != colors[n]) {
                return j;
            }

        }
        return 0;
    }
}
