import java.util.Arrays;

class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        int n = intervals.length;
        Arrays.sort(intervals, (a, b) -> a[1] == b[1] ? a[0] - b[0] : b[1] - a[1]);
        int start = 0;
        int end = 0;
        int count = 0;
        for (int[] interval : intervals) {
            if (interval[0] >= start && interval[1] <= end) {
                count++;
            } else {
                start = interval[0];
                end = interval[1];
            }
        }
        return n - count;
    }
}
