class Solution20211202 {
    public int maxProduct(int[] nums) {
        int res = nums[0];
        int curMax = nums[0];
        int curMin = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMaxTimesThis = curMax * nums[i];
            int preMinTimesThis = curMin * nums[i];
            curMax = Math.max(nums[i], Math.max(preMaxTimesThis, preMinTimesThis));
            curMin = Math.min(nums[i], Math.min(preMaxTimesThis, preMinTimesThis));
            res = Math.max(curMax, res);
        }
        return res;
    }
}
