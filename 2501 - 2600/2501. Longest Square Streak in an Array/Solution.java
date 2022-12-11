import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestSquareStreak(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = -1;
        for (int num : nums) {
            int cur = num;
            int len = 0;
            while (set.contains(cur)) {
                len++;
                cur = cur * cur;
            }
            if (len >= 2) {
                res = Math.max(res, len);
            }
        }
        return res;
    }
}
