class Solution {
    public int minimumTime(String s) {
        int n = s.length();
        int res = n;
        int left = 0;
        for (int i = 0; i < n; i++) {
            left = Math.min(left + (s.charAt(i) - '0') * 2, i + 1);
            res = Math.min(res, left + n - 1 - i);
        }
        return res;
    }
}
