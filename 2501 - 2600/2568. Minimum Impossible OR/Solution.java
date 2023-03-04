import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minImpossibleOR(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int cur = 1;
        while (set.contains(cur)) {
            cur <<= 1;
        }
        return cur;
    }
}
