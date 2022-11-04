import java.util.Arrays;

class Solution {
    public long maximumBeauty(int[] flowers, long newFlowers, int target, int full, int partial) {
        Arrays.sort(flowers);
        int n = flowers.length;
        long[] pref = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            pref[i] = pref[i - 1] + flowers[i - 1];
        }
        long ans = 0;
        long fill = 0;
        for (int i = n; i >= 0; i--) {
            if (i > 0 && flowers[i - 1] >= target) {
                continue;
            }
            if (i < n) {
                fill += Math.max(0, target - flowers[i]);
            }
            if (fill > newFlowers) {
                break;
            }
            if (i == 0) {
                ans = Math.max(ans, ((long) full) * n);
                break;
            }
            long val = ((long) full) * (n - i);
            int lo = flowers[0];
            int hi = target - 1;
            while (lo < hi) {
                //bring the partial gardens up to "m"
                // largest smaller or equal
                int m = (lo + hi + 1) / 2;
                int L = 0;
                int R = i - 1;
                while (L < R) {
                    // largest smaller or equal
                    int M = (L + R + 1) / 2;
                    if (flowers[M] <= m) {
                        L = M;
                    } else {
                        R = M - 1;
                    }
                }
                long cost = ((long) m) * (L + 1) - pref[L + 1];
                if (fill + cost <= newFlowers) {
                    lo = m;
                } else {
                    hi = m - 1;
                }
            }
            val += ((long) partial) * lo;
            ans = Math.max(ans, val);
        }
        return ans;
    }
}
