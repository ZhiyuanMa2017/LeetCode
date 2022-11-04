import java.util.TreeMap;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        int l = 0;
        int r = 1;
        TreeMap<Integer, Integer> map = new TreeMap<>();
        map.put(nums[0], 1);
        int res = 1;
        while (r < nums.length) {
            int num = nums[r];
            map.put(num, map.getOrDefault(num, 0) + 1);
            if (map.lastKey() - map.firstKey() <= limit) {
                res = Math.max(res, r - l + 1);
            } else {
                while (l <= r && map.lastKey() - map.firstKey() > limit) {
                    num = nums[l];
                    map.put(num, map.get(num) - 1);
                    if (map.get(num) == 0) {
                        map.remove(num);
                    }
                    l++;
                }
            }
            r++;
        }
        return res;
    }
}
