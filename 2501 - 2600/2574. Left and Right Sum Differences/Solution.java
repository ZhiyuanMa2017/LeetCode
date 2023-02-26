class Solution {
    public int[] leftRigthDifference(int[] nums) {
        int n = nums.length;
        int r = 0;
        for (int num : nums) {
            r += num;
        }
        int l = 0;
        int[] res = new int[n];
        for (int i = 0; i < n; i++) {
            r -= nums[i];
            res[i] = Math.abs(l - r);
            l += nums[i];
        }
        return res;
    }
}
