import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int brightestPosition(int[][] lights) {
        Map<Integer, Integer> map = new TreeMap<>();
        for (int[] light : lights) {
            int start = light[0] - light[1];
            int end = light[0] + light[1] + 1;
            map.put(start, map.getOrDefault(start, 0) + 1);
            map.put(end, map.getOrDefault(end, 0) - 1);
        }
        int res = 0;
        int cur = 0;
        int index = 0;
        for (Integer key : map.keySet()) {
            cur += map.get(key);
            if (cur > res) {
                res = cur;
                index = key;
            }
        }
        return index;
    }
}
