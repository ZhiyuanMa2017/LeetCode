import java.util.Arrays;

class Solution {
    public int smallestRangeII(int[] A, int K) {
        Arrays.sort(A);
        int n = A.length;
        int maxnum = A[n - 1];
        int minnum = A[0];
        int res = maxnum - minnum;
        if (res >= 4 * K) {
            return res - 2 * K;
        }
        if (res <= K) {
            return res;
        }
        for (int i = 0; i < n - 1; i++) {
            maxnum = Math.max(A[i] + 2 * K, maxnum);
            minnum = Math.min(A[i + 1], A[0] + 2 * K);
            res = Math.min(maxnum - minnum, res);
        }
        return res;
    }
}