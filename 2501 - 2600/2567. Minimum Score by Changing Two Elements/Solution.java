import java.util.Arrays;

class Solution {
    public int minimizeSum(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int res = nums[n - 3] - nums[0];
        res = Math.min(res, nums[n - 1] - nums[2]);
        res = Math.min(res, nums[n - 2] - nums[1]);
        return res;
    }
}
