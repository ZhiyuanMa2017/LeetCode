class Solution {
    public int findKthPositive(int[] A, int k) {
        int l = 0;
        int r = A.length;
        int m;
        while (l < r) {
            m = (l + r) / 2;
            if (A[m] - 1 - m < k) {
                l = m + 1;
            } else {
                r = m;
            }
        }
        return l + k;
    }
}
