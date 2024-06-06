import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

class Solution {
    public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) {
            return false;
        }
        TreeSet<Integer> treeSet = new TreeSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : hand) {
            treeSet.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num : treeSet) {
            if (map.get(num) == 0) {
                continue;
            }
            int cur = num;
            int cnt = map.get(cur);
            map.put(cur, 0);
            int size = groupSize - 1;
            while (size > 0) {
                cur++;
                size--;
                if (!map.containsKey(cur)) {
                    return false;
                }
                if (map.get(cur) < cnt) {
                    return false;
                }
                map.put(cur, map.get(cur) - cnt);
            }
        }
        return true;
    }
}
