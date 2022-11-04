import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public long countExcellentPairs(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        List<Integer> list = new ArrayList<>(set);
        int[] count = new int[33];
        long res = 0;
        long self = 0;
        for (Integer integer : list) {
            int digit = Integer.bitCount(integer);
            if (digit * 2 >= k) {
                self++;
            }
            int need = Math.max(0, k - digit);
            for (int i = need; i <= 32; i++) {
                res += count[i];
            }
            count[digit]++;
        }
        return res * 2 + self;
    }
}
