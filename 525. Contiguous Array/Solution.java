import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findMaxLength(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int prefix = 0;
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i] == 1 ? 1 : -1;
            if (map.containsKey(prefix)) {
                res = Math.max(res, i - map.get(prefix));
            } else {
                map.put(prefix, i);
            }
        }
        return res;
    }
}
