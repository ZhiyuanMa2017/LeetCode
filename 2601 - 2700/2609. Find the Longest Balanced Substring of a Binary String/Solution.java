class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int res = 0;
        int one = 0;
        int zero = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                if (one != 0) {
                    zero = 0;
                    one = 0;
                }
                zero++;
            } else {
                one++;
                if (one <= zero) {
                    res = Math.max(res, one * 2);
                }
            }
        }
        return res;
    }
}
