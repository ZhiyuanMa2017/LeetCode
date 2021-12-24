import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    public int[][] merge(int[][] intervals) {
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i][0];
            ends[i] = intervals[i][1];
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        ArrayList<int[]> result = new ArrayList<>();
        for (int last = 0, first = 0; last < intervals.length; last++) {
            if (last == intervals.length - 1 || starts[last + 1] > ends[last]) {
                result.add(new int[]{starts[first], ends[last]});
                first = last + 1;
            }
        }
        return result.toArray(new int[0][]);
    }
}
