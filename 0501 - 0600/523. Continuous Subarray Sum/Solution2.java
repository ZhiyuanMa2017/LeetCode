import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int n = nums.length;
        int[] remain = new int[n];
        for (int i = 0; i < n; i++) {
            remain[i] = nums[i] % k;
        }
        int sum = remain[0];
        Set<Integer> set = new HashSet<>();
        set.add(0);
        for (int i = 1; i < n; i++) {
            int cur = (sum + remain[i]) % k;
            if (set.contains(cur)) {
                return true;
            }
            set.add(sum);
            sum = cur;
        }
        return false;
    }
}
