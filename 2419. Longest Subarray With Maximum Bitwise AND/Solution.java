class Solution {
    public int longestSubarray(int[] nums) {
        int max = -1;
        for (int num : nums) {
            max = Math.max(max, num);
        }
        int count = 0;
        int res = 0;
        for (int num : nums) {
            if (num == max) {
                count++;
                res = Math.max(res, count);
            } else {
                count = 0;
            }
        }
        return res;
    }
}
