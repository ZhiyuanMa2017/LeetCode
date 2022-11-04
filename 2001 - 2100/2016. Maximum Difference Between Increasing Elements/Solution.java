class Solution {
    public int maximumDifference(int[] nums) {
        int res = -1;
        int min = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > min) {
                res = Math.max(nums[i] - min, res);
            }
            min = Math.min(min, nums[i]);
        }
        return res;
    }
}
