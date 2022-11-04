class Solution {
    public String longestPalindrome(String s) {
        String res = s.substring(0, 1);
        for (int i = 0; i < s.length() - 1; i++) {
            String o = centerextend(s, i, i);
            String e = centerextend(s, i, i + 1);
            if (o.length() > res.length()) {
                res = o;
            }
            if (e.length() > res.length()) {
                res = e;
            }
        }
        return res;
    }

    private String centerextend(String s, int left, int right) {
        while (left >= 0 && right < s.length()) {
            if (s.charAt(left) == s.charAt(right)) {
                left--;
                right++;
            } else {
                break;
            }
        }
        return s.substring(left + 1, right);
    }
}
