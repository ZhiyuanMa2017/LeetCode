class Solution {
    public int largestCombination(int[] candidates) {
        int res = 0;
        int cur;
        int val = 1;
        for (int i = 0; i < 24; i++) {
            cur = 0;
            for (int candidate : candidates) {
                if ((candidate & val) > 0) {
                    cur++;
                }
            }
            res = Math.max(res, cur);
            val <<= 1;
        }
        return res;
    }
}
