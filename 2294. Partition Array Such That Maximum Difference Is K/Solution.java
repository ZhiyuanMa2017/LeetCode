import java.util.Arrays;

class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int res = 0;
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] - curMin > k) {
                res++;
                curMin = nums[i];
            }
        }
        res++;
        return res;
    }
}
