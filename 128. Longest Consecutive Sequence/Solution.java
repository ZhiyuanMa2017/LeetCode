import java.util.HashSet;
import java.util.Set;

class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int res = 0;
        for (Integer i : set) {
            if (!set.contains(i - 1)) {
                int m = i + 1;
                while (set.contains(m)) {
                    m++;
                }
                res = Math.max(res, m - i);
            }
        }
        return res;
    }
}
