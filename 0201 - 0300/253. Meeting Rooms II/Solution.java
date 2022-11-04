import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minMeetingRooms(int[][] intervals) {
        Map<Integer, Integer> time = new TreeMap<>();
        for (int[] interval : intervals) {
            time.put(interval[0], time.getOrDefault(interval[0], 0) + 1);
            time.put(interval[1], time.getOrDefault(interval[1], 0) - 1);
        }
        int res = 0;
        int cur = 0;
        for (Integer value : time.values()) {
            cur += value;
            res = Math.max(cur, res);
        }
        return res;
    }
}
