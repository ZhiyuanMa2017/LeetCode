class Solution {
    public int maxProduct(int[] nums) {
        int n = nums.length;
        int prefix = 0;
        int suffix = 0;
        int res = nums[0];
        for (int i = 0; i < n; i++) {
            prefix = prefix == 0 ? 1 : prefix;
            prefix *= nums[i];
            suffix = suffix == 0 ? 1 : suffix;
            suffix *= nums[n - i - 1];
            res = Math.max(res, Math.max(prefix, suffix));
        }
        return res;
    }
}
