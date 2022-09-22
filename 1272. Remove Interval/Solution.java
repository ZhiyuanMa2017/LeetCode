import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> removeInterval(int[][] intervals, int[] toBeRemoved) {
        List<List<Integer>> res = new ArrayList<>();
        int start = toBeRemoved[0];
        int end = toBeRemoved[1];
        for (int[] interval : intervals) {
            int s = interval[0];
            int e = interval[1];
            if (e <= start || s >= end) {
                res.add(List.of(s, e));
            } else {
                if (s < start) {
                    res.add(List.of(s, start));
                }
                if (e > end) {
                    res.add(List.of(end, e));
                }
            }
        }
        return res;
    }
}
