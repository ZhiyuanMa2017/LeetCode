class Solution20211222 {
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        int l = 1;
        int r = n;
        for (int i = 0; i < n; i++) {
            if (k % 2 == 0) {
                res[i] = l;
                l++;
            } else {
                res[i] = r;
                r--;
            }
            if (k > 1) {
                k--;
            }
        }
        return res;
    }
}
