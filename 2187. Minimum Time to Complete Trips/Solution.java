import java.util.Arrays;

class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        Arrays.sort(time);
        long low = 1;
        long high = 10000000L * 10000000;
        while (low < high) {
            long mid = low + (high - low) / 2;
            if (cal(time, mid) >= totalTrips) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    private long cal(int[] time, long total) {
        long res = 0;
        for (int i : time) {
            if (i > total) {
                break;
            }
            res += total / i;
        }
        return res;
    }
}
