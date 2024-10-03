import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minSubarray(int[] nums, int p) {
        int n = nums.length;
        int remainder = 0;
        for (int num : nums) {
            remainder = (remainder + num) % p;
        }
        if (remainder == 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, -1);
        int cur = 0;
        int res = n;
        for (int i = 0; i < n; i++) {
            cur = (cur + nums[i]) % p;
            int another = (cur + p - remainder) % p;
            if (map.containsKey(another)) {
                res = Math.min(res, i - map.get(another));
            }
            map.put(cur, i);
        }
        if (res == n) {
            return -1;
        }
        return res;
    }
}
