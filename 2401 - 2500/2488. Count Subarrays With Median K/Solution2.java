import java.util.HashMap;
import java.util.Map;

class Solution {
    public int countSubarrays(int[] nums, int k) {
        int n = nums.length;
        int index = -1;
        for (int i = 0; i < n; i++) {
            if (nums[i] == k) {
                index = i;
                break;
            }
        }
        Map<Integer, Integer> preSum = new HashMap<>();
        preSum.put(0, 1);
        int cur = 0;
        for (int i = index - 1; i >= 0; i--) {
            cur += nums[i] > k ? 1 : -1;
            preSum.put(cur, preSum.getOrDefault(cur, 0) + 1);
        }
        cur = 0;
        int res = preSum.get(0) + preSum.getOrDefault(1, 0);
        for (int i = index + 1; i < n; i++) {
            cur += nums[i] > k ? 1 : -1;
            res += preSum.getOrDefault(-cur, 0) + preSum.getOrDefault(1 - cur, 0);
        }
        return res;
    }
}
