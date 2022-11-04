class Solution2 {
    public int maxProduct(int[] nums) {
        int curMax = nums[0];
        int curMin = nums[0];
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            int preMaxMultiplyThis = curMax * nums[i];
            int preMinMultiplyThis = curMin * nums[i];
            curMax = Math.max(nums[i], Math.max(preMaxMultiplyThis, preMinMultiplyThis));
            curMin = Math.min(nums[i], Math.min(preMaxMultiplyThis, preMinMultiplyThis));
            res = Math.max(res, curMax);
        }
        return res;
    }
}
