class Solution {
    public long maximumSubarraySum(int[] nums, int k) {
        long res = 0;
        int[] count = new int[100001];
        long cur = 0;
        int dup = 0;
        for (int i = 0; i < k - 1; i++) {
            cur += nums[i];
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                dup++;
            }
        }
        for (int i = k - 1; i < nums.length; i++) {
            cur += nums[i];
            count[nums[i]]++;
            if (count[nums[i]] > 1) {
                dup++;
            }
            if (dup == 0) {
                res = Math.max(res, cur);
            }
            cur -= nums[i - (k - 1)];
            count[nums[i - (k - 1)]]--;
            if (count[nums[i - (k - 1)]] >= 1) {
                dup--;
            }
        }
        return res;
    }
}
