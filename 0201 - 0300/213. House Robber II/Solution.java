import java.util.Arrays;

class Solution {
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        return Math.max(robHelper(Arrays.copyOfRange(nums, 0, nums.length - 1)), robHelper(Arrays.copyOfRange(nums, 1, nums.length)));
    }

    private int robHelper(int[] nums) {
        int res = 0;
        int rob = 0;
        int noRob = 0;
        for (int num : nums) {
            int newRob = noRob + num;
            noRob = Math.max(rob, noRob);
            rob = newRob;
        }
        return Math.max(rob, noRob);
    }
}
