class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int count = 0;
        for (int num : nums) {
            if (num == 0) {
                count = 0;
            } else {
                count += 1;
                res = Math.max(count, res);
            }
        }
        return res;
    }
}