import java.util.HashMap;
import java.util.Map;

class Solution {
    public long beautifulSubarrays(int[] nums) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int preSum = 0;
        for (int num : nums) {
            preSum ^= num;
            res += map.getOrDefault(preSum, 0);
            map.put(preSum, map.getOrDefault(preSum, 0) + 1);
        }
        return res;
    }
}
