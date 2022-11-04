import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public int[] avoidFlood(int[] rains) {
        Map<Integer, Integer> previous = new HashMap<>();
        TreeSet<Integer> zeros = new TreeSet<>();
        int[] res = new int[rains.length];
        for (int i = 0; i < rains.length; i++) {
            if (rains[i] == 0) {
                res[i] = 1;
                zeros.add(i);
            } else {
                if (previous.containsKey(rains[i])) {
                    int index = previous.get(rains[i]);
                    Integer next = zeros.ceiling(index);
                    if (next == null) {
                        return new int[]{};
                    }
                    zeros.remove(next);
                    res[next] = rains[i];
                }
                previous.put(rains[i], i);
            }
        }
        return res;
    }
}
