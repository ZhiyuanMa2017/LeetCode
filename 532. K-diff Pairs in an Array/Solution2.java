import java.util.HashMap;
import java.util.Map;

class Solution2 {
    public int findPairs(int[] nums, int k) {
        Map<Integer, Integer> counter = new HashMap<>();
        int res = 0;
        for (int num : nums) {
            counter.put(num, counter.getOrDefault(num, 0) + 1);
        }
        for (Integer key : counter.keySet()) {
            if (k > 0 && counter.containsKey(key + k)) {
                res++;
            }
            if (k == 0 && counter.get(key) > 1) {
                res++;
            }
        }
        return res;
    }
}
