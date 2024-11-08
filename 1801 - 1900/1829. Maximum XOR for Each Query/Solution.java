class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] res = new int[n];
        int total = 0;
        for (int num : nums) {
            total ^= num;
        }
        int bitmask = (1 << maximumBit) - 1;
        for (int i = 0; i < n; i++) {
            res[i] = total ^ bitmask;
            total ^= nums[n - 1 - i];
        }
        return res;
    }
}
