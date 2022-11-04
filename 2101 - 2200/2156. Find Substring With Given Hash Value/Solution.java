class Solution {
    public String subStrHash(String s, int power, int modulo, int k, int hashValue) {
        int n = s.length();
        long b = 1;
        long cur = 0;
        int res = n - k;
        for (int i = n - k; i < n; i++) {
            cur = (cur + val(s.charAt(i)) * b) % modulo;
            b = b * power % modulo;
        }
        for (int i = n - k - 1; i >= 0; i--) {
            cur = (cur * power + val(s.charAt(i)) - val(s.charAt(i + k)) * b % modulo + modulo) % modulo;
            if (cur == hashValue) {
                res = i;
            }
        }
        return s.substring(res, res + k);
    }

    private int val(char c) {
        return c - 'a' + 1;
    }
}
