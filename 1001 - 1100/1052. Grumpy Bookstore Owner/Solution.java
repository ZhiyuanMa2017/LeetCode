class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int n = customers.length;
        int cur = 0;
        for (int i = 0; i < n; i++) {
            if (i < minutes) {
                cur += customers[i];
            } else {
                if (grumpy[i] == 0) {
                    cur += customers[i];
                }
            }
        }
        int res = cur;
        if (minutes >= n) {
            return res;
        }
        int l = 0;
        int r = minutes;
        while (r < n) {
            if (grumpy[r] == 1) {
                cur += customers[r];
            }
            if (grumpy[l] == 1) {
                cur -= customers[l];
            }
            l++;
            r++;
            res = Math.max(res, cur);
        }
        return res;
    }
}
