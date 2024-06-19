class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int n = bloomDay.length;
        if ((long) m * k > n) {
            return -1;
        }
        int l = 1;
        int r = (int) 1e9;
        while (l < r) {
            int mid = l + (r - l) / 2;
            int cur = check(bloomDay, k, mid);
            if (cur >= m) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;
    }

    private int check(int[] bloomDay, int k, int day) {
        int res = 0;
        int cur = 0;
        for (int bd : bloomDay) {
            if (bd <= day) {
                cur++;
            } else {
                cur = 0;
            }
            if (cur == k) {
                res++;
                cur = 0;
            }
        }
        return res;
    }
}
