import java.util.HashMap;
import java.util.Map;

class Solution {
    public long countGood(int[] nums, int k) {
        int n = nums.length;
        long res = 0;
        int left = 0;
        long total = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int right = 0; right < n; right++) {
            int num = nums[right];
            int count = map.getOrDefault(num, 0);
            total += count;
            map.put(num, count + 1);
            while (left < right) {
                count = map.get(nums[left]);
                if (total - (count - 1) >= k) {
                    map.put(nums[left], count - 1);
                    total -= count - 1;
                    left++;
                } else {
                    break;
                }
            }
            if (total >= k) {
                res += left + 1;
            }
        }
        return res;
    }
}
