import java.util.Arrays;

class Solution {
    public int jump(int[] nums) {
        int jumps = 0, curEnd = 0, curFarthest = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curFarthest = Math.max(curFarthest, nums[i] + i);
            if (curFarthest >= nums.length - 1) {
                jumps++;
                break;
            }
            if (i == curEnd) {
                jumps++;
                curEnd = curFarthest;
            }
        }
        return jumps;
    }

    public int jump2(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, (int) (Math.pow(10, 5) + 1));
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                continue;
            }
            for (int j = 1; j <= nums[i]; j++) {
                int index = i + j;
                if (index < n) {
                    dp[index] = Math.min(dp[index], dp[i] + 1);
                }
            }
        }
        return dp[n - 1];
    }
}
