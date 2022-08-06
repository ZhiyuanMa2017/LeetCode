class Solution {
    public int waysToSplit(int[] nums) {
        int n = nums.length;
        for (int i = 1; i < n; i++) {
            nums[i] += nums[i - 1];
        }
        int l = 0;
        int r = 0;
        int res = 0;
        int mod = 1000000007;
        for (int left = 0; left < n - 2; left++) {
            l = Math.max(left + 1, l);
            while (l < n - 1 && nums[l] - nums[left] < nums[left]) {
                l++;
            }
            r = Math.max(l, r);
            while (r < n - 1 && nums[n - 1] - nums[r] >= nums[r] - nums[left]) {
                r++;
            }
            res = (res + r - l) % mod;
        }
        return res;
    }
}
