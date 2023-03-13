import java.util.Arrays;

class Solution {
    public int maxScore(int[] nums) {
        int n = nums.length;
        int res = 0;
        Arrays.sort(nums);
        long preSum = 0;
        for (int i = n - 1; i >= 0; i--) {
            preSum += nums[i];
            if (preSum > 0) {
                res++;
            }
        }
        return res;
    }
}
