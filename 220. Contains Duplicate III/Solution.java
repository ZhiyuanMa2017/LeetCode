import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        int n = nums.length;
        Map<Long, Long> map = new HashMap<>();
        long size = t + 1;
        for (int i = 0; i < n; i++) {
            long num = nums[i];
            long key = num >= 0 ? num / size : ((num + 1) / size) - 1;
            if (map.containsKey(key)) {
                return true;
            }
            long floor = key - 1;
            long ceiling = key + 1;
            if (map.containsKey(floor) && num - map.get(floor) <= t) {
                return true;
            }
            if (map.containsKey(ceiling) && map.get(ceiling) - num <= t) {
                return true;
            }
            map.put(key, num);
            if (map.size() > k) {
                long num2 = nums[i - k];
                map.remove(num2 >= 0 ? num2 / size : ((num2 + 1) / size) - 1);
            }
        }
        return false;
    }
}
