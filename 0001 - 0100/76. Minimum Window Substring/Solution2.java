class Solution2 {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();
        if (m < n) {
            return "";
        }
        int[] tt = new int[60];
        int[] window = new int[60];
        int total = 0;
        for (int i = 0; i < n; i++) {
            char c = t.charAt(i);
            tt[index(c)]++;
            if (tt[index(c)] == 1) {
                total++;
            }
        }
        int len = m + 1;
        int start = 0;
        int left = 0;
        int right = 0;
        while (right < m) {
            char c = s.charAt(right);
            window[index(c)]++;
            if (window[index(c)] == tt[index(c)]) {
                total--;
            }
            while (left < right) {
                char cc = s.charAt(left);
                if (window[index(cc)] > tt[index(cc)]) {
                    left++;
                    window[index(cc)]--;
                } else {
                    break;
                }
            }
            if (total == 0) {
                if (len > right - left + 1) {
                    len = right - left + 1;
                    start = left;
                }
            }
            right++;
        }
        if (len == m + 1) {
            return "";
        } else {
            return s.substring(start, start + len);
        }
    }

    private int index(char c) {
        if (c >= 'a' && c <= 'z') {
            return c - 'a';
        } else {
            return c - 'A' + 26;
        }
    }
}
