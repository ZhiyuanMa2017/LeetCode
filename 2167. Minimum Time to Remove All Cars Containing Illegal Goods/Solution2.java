class Solution2 {
    public int minimumTime(String s) {
        int n = s.length();
        int[] l = new int[n];
        l[0] = s.charAt(0) == '1' ? 1 : 0;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == '0') {
                l[i] = l[i - 1];
            } else {
                l[i] = Math.min(l[i - 1] + 2, i + 1);
            }
        }

        int[] r = new int[n];
        r[n - 1] = s.charAt(n - 1) == '1' ? 1 : 0;
        for (int i = n - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                r[i] = r[i + 1];
            } else {
                r[i] = Math.min(r[i + 1] + 2, n - i);
            }
        }
        int res = r[0];
        for (int i = 0; i < n - 1; i++) {
            res = Math.min(res, l[i] + r[i + 1]);
        }
        res = Math.min(res, l[n - 1]);
        return res;
    }
}
