class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n];
        int left = 0;
        for (int right = 1; right < n; right++) {
            while (left + nums[left] < right) {
                left++;
            }
            dp[right] = dp[left] + 1;
        }
        return dp[n - 1];
    }
}
