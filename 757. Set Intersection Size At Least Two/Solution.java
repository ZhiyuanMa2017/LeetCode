import java.util.Arrays;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? b[0] - a[0] : a[1] - b[1]);
        int a = intervals[0][1] - 1;
        int b = intervals[0][1];
        int res = 2;
        for (int i = 1; i < intervals.length; i++) {
            int start = intervals[i][0];
            int end = intervals[i][1];
            if (a < start && start <= b) {
                res++;
                a = b;
                b = end;
            } else if (b < start) {
                res += 2;
                a = end - 1;
                b = end;
            }
        }
        return res;
    }
}
