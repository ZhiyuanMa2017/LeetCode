class Solution {
    public String greatestLetter(String s) {
        boolean[] up = new boolean[26];
        boolean[] low = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) {
                up[c - 'A'] = true;
            } else if (Character.isLowerCase(c)) {
                low[c - 'a'] = true;
            }
        }
        for (int i = 25; i >= 0; i--) {
            if (up[i] && low[i]) {
                return String.valueOf((char) ('A' + i));
            }
        }
        return "";
    }
}
