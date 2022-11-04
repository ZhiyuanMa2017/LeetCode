import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public int findPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int n = nums.length;
        Set<Integer> visited = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i < n - 1 && nums[i + 1] == nums[i]) {
                visited.add(nums[i]);
                continue;
            }
            if (visited.contains(nums[i] - k)) {
                res++;
            }
            visited.add(nums[i]);
        }
        return res;
    }
}
