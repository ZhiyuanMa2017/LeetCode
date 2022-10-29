class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int cur = 0;
        int prev = 0;
        int zero = 0;
        for (int num : nums) {
            if (num == 1) {
                cur++;
            } else {
                zero = 1;
                prev = cur;
                cur = 0;
            }
            res = Math.max(res, cur + prev + zero);
        }
        return res;
    }
}
