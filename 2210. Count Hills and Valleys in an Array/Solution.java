class Solution {
    public int countHillValley(int[] nums) {
        int prev = nums[0];
        int res = 0;
        for (int i = 1; i < nums.length - 1; i++) {
            if (prev < nums[i] && nums[i] > nums[i + 1]) {
                res++;
                prev = nums[i];
            } else if (prev > nums[i] && nums[i] < nums[i + 1]) {
                res++;
                prev = nums[i];
            }
        }
        return res;
    }
}
