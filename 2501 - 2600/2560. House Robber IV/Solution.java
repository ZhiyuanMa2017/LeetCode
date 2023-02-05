class Solution {
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE;
        int r = Integer.MIN_VALUE;
        for (int num : nums) {
            l = Math.min(l, num);
            r = Math.max(r, num);
        }
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(mid, nums, k)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private boolean check(int value, int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0] <= value ? 1 : 0;
        dp[1] = Math.max(dp[0], nums[1] <= value ? 1 : 0);
        for (int i = 2; i < n; i++) {
            if (nums[i] <= value) {
                dp[i] = Math.max(dp[i - 1], dp[i - 2] + 1);
            } else {
                dp[i] = Math.max(dp[i - 1], dp[i - 2]);
            }
        }
        return dp[n - 1] >= k;
    }
}
