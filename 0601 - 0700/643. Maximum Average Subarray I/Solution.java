class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int cur = 0;
        for (int i = 0; i < k; i++) {
            cur += nums[i];
        }
        int res = cur;
        for (int i = k; i < nums.length; i++) {
            cur += nums[i] - nums[i - k];
            res = Math.max(cur, res);
        }
        return ((double) res) / k;
    }
}
