import java.util.HashSet;
import java.util.Set;

class Solution {
    public int countDistinct(int[] nums, int k, int p) {
        Set<String> set = new HashSet<>();
        boolean[] divisible = new boolean[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % p == 0) {
                divisible[i] = true;
            }
        }

        for (int i = 0; i < nums.length; i++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            for (int j = i; j < nums.length; j++) {
                if (divisible[j]) {
                    count++;
                }
                if (count > k) {
                    break;
                }
                sb.append(nums[j]).append("-");
                set.add(sb.toString());
            }
        }
        return set.size();
    }
}
