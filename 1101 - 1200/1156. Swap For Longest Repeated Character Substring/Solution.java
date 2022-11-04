class Solution {
    public int maxRepOpt1(String text) {
        int[] count = new int[26];
        int res = 0;
        for (int i = 0; i < text.length(); i++) {
            char c = text.charAt(i);
            count[c - 'a']++;
            res = Math.max(res, count[c - 'a']);
        }
        if (res == 1) {
            return res;
        }
        res = 0;
        int[] last = new int[26];
        int i = 0;
        while (i < text.length()) {
            int j = i + 1;
            while (j < text.length() && text.charAt(i) == text.charAt(j)) {
                j++;
            }
            int len = j - i;
            if (i > 1 && text.charAt(i - 2) == text.charAt(i)) {
                int cur = len + last[text.charAt(i) - 'a'];
                if (cur < count[text.charAt(i) - 'a']) {
                    cur++;
                }
                res = Math.max(res, cur);
            } else {
                int cur = len;
                if (cur < count[text.charAt(i) - 'a']) {
                    cur++;
                }
                res = Math.max(res, cur);
            }
            last[text.charAt(i) - 'a'] = len;
            i = j;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.maxRepOpt1("ababa");
    }
}
