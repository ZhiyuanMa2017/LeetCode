class Solution {
    public String longestNiceSubstring(String s) {
        int n = s.length();
        int index = -1;
        int len = 0;
        for (int i = 0; i < n; i++) {
            int lower = 0;
            int upper = 0;
            for (int j = i; j < n; j++) {
                char c = s.charAt(j);
                if (c >= 'a' && c <= 'z') {
                    lower |= (1 << (c - 'a'));
                } else {
                    upper |= (1 << (c - 'A'));
                }
                if (upper == lower && j - i + 1 > len) {
                    index = i;
                    len = j - i + 1;
                }
            }
        }
        return index == -1 ? "" : s.substring(index, index + len);
    }
}
