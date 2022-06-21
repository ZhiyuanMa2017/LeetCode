class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int n = s.length();
        for (int i = 1; i <= s.length() / 2; i++) {
            if (n % i == 0) {
                String sub = s.substring(0, i);
                sub = sub.repeat(n / i);
                if (sub.equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}
