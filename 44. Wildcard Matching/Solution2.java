class Solution2 {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int lastMatch = -1;
        int starIndex = -1;
        while (i < s.length()) {
            if (j < p.length() && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '?')) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                starIndex = j;
                lastMatch = i;
                j++;
            } else if (starIndex != -1) {
                j = starIndex + 1;
                lastMatch++;
                i = lastMatch;
            } else {
                return false;
            }
        }
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        return j == p.length();
    }
}
