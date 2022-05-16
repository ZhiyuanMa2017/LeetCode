class Solution {
    public int findPoisonedDuration(int[] timeSeries, int duration) {
        int res = 0;
        int start = timeSeries[0];
        int end = timeSeries[0] + duration - 1;
        for (int i = 1; i < timeSeries.length; i++) {
            int time = timeSeries[i];
            if (end >= time) {
                end = time + duration - 1;
            } else {
                res += end - start + 1;
                start = time;
                end = time + duration - 1;
            }
        }
        res += end - start + 1;
        return res;
    }
}
