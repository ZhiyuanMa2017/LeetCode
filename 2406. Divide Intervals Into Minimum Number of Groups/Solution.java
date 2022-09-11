import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int minGroups(int[][] intervals) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] interval : intervals) {
            int left = interval[0];
            int right = interval[1];
            map.put(left, map.getOrDefault(left, 0) + 1);
            map.put(right + 1, map.getOrDefault(right + 1, 0) - 1);
        }
        int res = 0;
        int cur = 0;
        for (Integer integer : map.values()) {
            cur += integer;
            res = Math.max(res, cur);
        }
        return res;
    }
}
