class Solution2 {
    public int nthUglyNumber(int n) {
        int[] res = new int[n];
        res[0] = 1;
        int index2 = 0;
        int index3 = 0;
        int index5 = 0;
        for (int i = 1; i < n; i++) {
            int a = res[index2] * 2;
            int b = res[index3] * 3;
            int c = res[index5] * 5;
            int min = Math.min(a, Math.min(b, c));
            res[i] = min;
            if (a == min) {
                index2++;
            }
            if (b == min) {
                index3++;
            }
            if (c == min) {
                index5++;
            }
        }
        return res[n - 1];
    }
}
