class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
        int[] loc = new int[1001];
        for (int[] trip : trips) {
            loc[trip[1]] -= trip[0];
            loc[trip[2]] += trip[0];
        }
        int cur = capacity;
        for (int i = 0; i < 1001; i++) {
            cur += loc[i];
            if (cur < 0) {
                return false;
            }
        }
        return true;
    }
}
