import java.util.HashSet;
import java.util.Set;

class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int res = 0;
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        for (int num : nums) {
            if (set.contains(num - diff) && set.contains(num + diff)) {
                res++;
            }
        }
        return res;
    }
}
