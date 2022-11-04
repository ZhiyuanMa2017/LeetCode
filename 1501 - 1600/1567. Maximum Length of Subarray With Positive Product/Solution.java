class Solution {
    public int getMaxLen(int[] nums) {
        int pos = 0;
        int neg = 0;
        int res = 0;
        for (int num : nums) {
            if (num == 0) {
                pos = 0;
                neg = 0;
            } else if (num > 0) {
                pos++;
                neg = neg > 0 ? neg + 1 : 0;
            } else {
                int newNeg = pos + 1;
                int newPos = neg > 0 ? neg + 1 : 0;
                pos = newPos;
                neg = newNeg;
            }
            res = Math.max(res, pos);
        }
        return res;
    }
}
