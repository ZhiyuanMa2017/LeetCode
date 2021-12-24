import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution20211223 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
        List<int[]> res = new ArrayList<>();
        int[] cur = intervals[0];
        int index = 1;
        while (index < intervals.length) {
            if (cur[1] >= intervals[index][0]) {
                cur[1] = Math.max(cur[1], intervals[index][1]);
                index++;
            } else {
                res.add(cur);
                cur = intervals[index];
                index++;
            }
        }
        res.add(cur);
        return res.toArray(new int[0][]);
    }
}
