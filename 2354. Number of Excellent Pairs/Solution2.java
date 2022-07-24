import java.util.HashSet;
import java.util.Set;

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int[] count = new int[32];
        for (int num : nums) {
            if (!set.contains(num)) {
                count[Integer.bitCount(num)]++;
                set.add(num);
            }
        }
        long res = 0;
        for (int i = 1; i < 32; i++) {
            for (int j = 1; j < 32; j++) {
                if (i + j >= k) {
                    res += (long) count[i] * count[j];
                }
            }
        }
        return res;
    }
}
