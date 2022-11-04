class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int res = 0;
        int curCount = 0;
        for (int num : nums) {
            if (num == 1) {
                curCount += 1;
            } else {
                res = Math.max(res, curCount);
                curCount = 0;
            }
        }
        res = Math.max(res, curCount);
        return res;
    }
}
