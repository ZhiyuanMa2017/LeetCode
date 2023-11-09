class Solution {
    public int countHomogenous(String s) {
        int mod = (int) 1e9 + 7;
        int res = 1;
        int cur = 1;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                cur++;
            } else {
                cur = 1;
            }
            res = (res + cur) % mod;
        }
        return res;
    }
}
