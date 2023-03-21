class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0;
        int cur = 0;
        for (int num : nums) {
            res += cur;
            if (num == 0) {
                cur++;
            } else {
                cur = 0;
            }
        }
        res += cur;
        return res;
    }
}
