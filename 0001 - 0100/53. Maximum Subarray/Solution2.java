class Solution2 {
    public int maxSubArray(int[] nums) {
        int preSum = 0;
        int min = 0;
        int res = -10001;
        for (int num : nums) {
            preSum += num;
            res = Math.max(res, preSum - min);
            min = Math.min(min, preSum);
        }
        return res;
    }
}
