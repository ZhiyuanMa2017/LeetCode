import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public boolean isPossible(int[] nums) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int num : nums) {
            if (!map.containsKey(num)) {
                map.put(num, new PriorityQueue<>());
            }
            if (map.containsKey(num - 1)) {
                int length = map.get(num - 1).poll();
                if (map.get(num - 1).size() == 0) {
                    map.remove(num - 1);
                }
                map.get(num).offer(length + 1);
            } else {
                map.get(num).offer(1);
            }
        }
        for (Integer num : map.keySet()) {
            if (map.get(num).peek() < 3) {
                return false;
            }
        }
        return true;
    }
}
