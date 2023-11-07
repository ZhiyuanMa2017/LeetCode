import java.util.Arrays;

class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        int n = dist.length;
        int[] time = new int[n];
        for (int i = 0; i < n; i++) {
            time[i] = (dist[i] + speed[i] - 1) / speed[i];
        }
        Arrays.sort(time);
        for (int i = 1; i < n; i++) {
            if (time[i] <= i) {
                return i;
            }
        }
        return n;
    }
}
