import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaxK(int[] nums) {
        int res = -1;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (num > 0 && set.contains(-num)) {
                res = Math.max(res, num);
            }

        }
        return res;
    }
}
