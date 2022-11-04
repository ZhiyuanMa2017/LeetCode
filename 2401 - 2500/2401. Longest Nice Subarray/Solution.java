class Solution {
    public int longestNiceSubarray(int[] nums) {
        int left = 0;
        int cur = nums[0];
        int res = 0;
        for (int right = 0; right < nums.length; right++) {
            while ((cur & nums[right]) != 0) {
                cur = cur ^ nums[left];
                left++;
            }
            cur |= nums[right];
            res = Math.max(res, right - left + 1);
        }
        return res;
    }
}
