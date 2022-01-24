import java.util.HashMap;
import java.util.Map;

class Solution {
    public int numRabbits(int[] answers) {
        Map<Integer, Integer> counter = new HashMap<>();
        for (int num : answers) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        int res = 0;
        for (int key : counter.keySet()) {
            int count = counter.get(key);
            if (count % (key + 1) != 0) {
                res += (1 + count / (key + 1)) * (key + 1);
            } else {
                res += (count / (key + 1)) * (key + 1);
            }
        }
        return res;
    }
}
