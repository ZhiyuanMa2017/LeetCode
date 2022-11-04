class Solution {
    public String makeGood(String s) {
        int n = s.length();
        for (int i = 0; i < s.length() - 1; i++) {
            if (check(s.charAt(i), s.charAt(i + 1))) {
                s = s.substring(0, i) + s.substring(i + 2);
                break;
            }
        }
        if (s.length() == n) {
            return s;
        } else {
            return makeGood(s);
        }
    }


    private boolean check(char c, char b) {
        if (Character.toLowerCase(c) == Character.toLowerCase(b)) {
            return c != b;
        }
        return false;
    }
}
