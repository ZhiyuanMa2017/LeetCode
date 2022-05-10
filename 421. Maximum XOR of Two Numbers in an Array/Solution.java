import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findMaximumXOR(int[] nums) {
        int res = 0;
        int mask = 0;
        for (int i = 31; i >= 0; i--) {
            mask |= 1 << i;
            Set<Integer> set = new HashSet<>();
            for (int num : nums) {
                set.add(num & mask);
            }
            int potential = res | 1 << i;
            for (Integer integer : set) {
                if (set.contains(potential ^ integer)) {
                    res = potential;
                    break;
                }
            }
        }
        return res;
    }
}
