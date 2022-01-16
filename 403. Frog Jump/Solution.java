import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s : stones) {
            map.put(s, new HashSet<>());
        }
        map.get(0).add(0);
        for (int s : stones) {
            for (int k : map.get(s)) {
                for (int i = k - 1; i < k + 2; i++) {
                    if (i > 0 && map.containsKey(s + i)) {
                        map.get(s + i).add(i);
                    }
                }
            }
        }
        return map.get(stones[stones.length - 1]).size() > 0;
    }
}
