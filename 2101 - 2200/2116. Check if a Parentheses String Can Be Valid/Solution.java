class Solution {
    public boolean canBeValid(String s, String locked) {
        if (s.length() % 2 != 0) {
            return false;
        }
        int n = s.length();
        int open = 0;
        int close = 0;
        int total = 0;
        for (int i = 0; i < n; i++) {
            if (locked.charAt(i) == '0') {
                total += 1;
            } else {
                if (s.charAt(i) == '(') {
                    open += 1;
                } else {
                    close += 1;
                }
            }
            if (total + open - close < 0) {
                return false;
            }
        }
        open = 0;
        close = 0;
        total = 0;
        for (int i = n - 1; i >= 0; i--) {
            if (locked.charAt(i) == '0') {
                total += 1;
            } else {
                if (s.charAt(i) == '(') {
                    open += 1;
                } else {
                    close += 1;
                }
            }
            if (total + close - open < 0) {
                return false;
            }
        }
        return true;
    }
}
