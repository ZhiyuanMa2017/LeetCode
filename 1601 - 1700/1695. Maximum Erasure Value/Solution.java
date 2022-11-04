import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maximumUniqueSubarray(int[] nums) {
        Set<Integer> appear = new HashSet<>();
        int i = 0;
        int j = 0;
        int res = 0;
        int tmp = 0;
        while (i < nums.length && j < nums.length) {
            if (!appear.contains(nums[j])) {
                tmp += nums[j];
                res = Math.max(res, tmp);
                appear.add(nums[j]);
                j++;
            } else {
                tmp -= nums[i];
                appear.remove(nums[i]);
                i++;
            }
        }
        return res;
    }
}
