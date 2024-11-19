import java.util.HashSet;
import java.util.Set;

class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        int n = nums.length;
        Set<Integer> set = new HashSet<>();
        long res = 0;
        long cur = 0;
        int left = 0;
        for (int right = 0; right < n; right++) {
            while (set.contains(nums[right])) {
                cur -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            if (set.size() == k) {
                cur -= nums[left];
                set.remove(nums[left]);
                left++;
            }
            set.add(nums[right]);
            cur += nums[right];
            if (set.size() == k) {
                res = Math.max(res, cur);
            }
        }
        return res;
    }
}
