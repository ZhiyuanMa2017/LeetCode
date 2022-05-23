import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        int[] preSum = new int[nums.length + 1];
        for (int i = 1; i <= nums.length; i++) {
            preSum[i] = (preSum[i - 1] + nums[i - 1]) % k;
        }
        Set<Integer> set = new HashSet<>();
        for (int i = 2; i <= nums.length; i++) {
            set.add(preSum[i - 2]);
            if (set.contains(preSum[i])) {
                return true;
            }
        }
        return false;
    }
}
