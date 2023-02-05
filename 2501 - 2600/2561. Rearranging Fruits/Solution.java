import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        Map<Integer, Integer> map = new HashMap<>();
        int n = basket1.length;
        for (int i = 0; i < n; i++) {
            int a = basket1[i];
            map.put(a, map.getOrDefault(a, 0) + 1);
            int b = basket2[i];
            map.put(b, map.getOrDefault(b, 0) - 1);
        }
        List<Integer> one = new ArrayList<>();
        List<Integer> two = new ArrayList<>();
        long min = Integer.MAX_VALUE;
        for (Integer key : map.keySet()) {
            int count = map.get(key);
            if (count % 2 == 1) {
                return -1;
            }
            min = Math.min(min, key);
            if (count > 0) {
                for (int i = 0; i < count / 2; i++) {
                    one.add(key);
                }
            } else {
                for (int i = 0; i < -count / 2; i++) {
                    two.add(key);
                }
            }
        }
        Collections.sort(one);
        Collections.sort(two);
        Collections.reverse(two);
        long res = 0;
        for (int i = 0; i < one.size(); i++) {
            res += Math.min(Math.min(one.get(i), two.get(i)), min * 2);
        }
        return res;
    }
}
