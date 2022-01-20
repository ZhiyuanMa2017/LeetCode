class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int l = 1;
        int r = 1000000000;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (check(piles, mid, h)) {
                r = mid;
            } else {
                l = mid + 1;
            }
        }
        return l;

    }

    private boolean check(int[] piles, int k, int h) {
        int res = 0;
        for (int p : piles) {
            if (p % k == 0) {
                res += p / k;
            } else {
                res += p / k + 1;
            }
        }
        return res <= h;
    }
}
