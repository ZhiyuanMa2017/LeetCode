import java.util.List;

class Solution {
    public int findMinDifference(List<String> timePoints) {
        boolean[] bucket = new boolean[24 * 60];
        for (String timePoint : timePoints) {
            int time = convert(timePoint);
            if (bucket[time]) {
                return 0;
            }
            bucket[time] = true;
        }
        int prev = -1;
        int first = -1;
        int last = 24 * 60 + 1;
        int res = 24 * 60;
        for (int i = 0; i < 24 * 60; i++) {
            if (bucket[i]) {
                if (prev != -1) {
                    res = Math.min(res, i - prev);
                } else {
                    first = i;
                }
                prev = i;
                last = i;
            }
        }
        res = Math.min(res, first + 24 * 60 - last);
        return res;
    }

    private int convert(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int min = Integer.parseInt(time.substring(3));
        return hour * 60 + min;
    }
}
