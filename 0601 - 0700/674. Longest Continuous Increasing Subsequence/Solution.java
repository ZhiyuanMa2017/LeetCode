class Solution {
    public int findLengthOfLCIS(int[] nums) {
        int n = nums.length;
        int cur = 1;
        int res = 1;
        for (int r = 0; r < n - 1; r++) {
            if (nums[r + 1] > nums[r]) {
                cur++;
                res = Math.max(cur, res);
            } else {
                cur = 1;
            }
        }
        return res;
    }
}
