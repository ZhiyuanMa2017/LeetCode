import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxNonOverlapping(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        map.put(0, 0);
        int preSum = 0;
        for (int num : nums) {
            preSum += num;
            if (map.containsKey(preSum - target)) {
                res = Math.max(res, map.get(preSum - target) + 1);
            }
            map.put(preSum, res);
        }
        return res;
    }
}
