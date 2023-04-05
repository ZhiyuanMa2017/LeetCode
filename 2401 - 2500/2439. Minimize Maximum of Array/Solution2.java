class Solution {
    public int minimizeArrayValue(int[] nums) {
        long preSum = 0;
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            preSum += nums[i];
            res = Math.max(res, (preSum + i) / (i + 1));
        }
        return (int) res;
    }
}
