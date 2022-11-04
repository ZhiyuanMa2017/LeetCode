class Solution {
    public int maxSubArray(int[] nums) {
        int m = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            m = Math.max(m + nums[i], nums[i]);
            res = Math.max(m, res);
        }
        return res;
    }
}
