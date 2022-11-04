class Solution {
    public int myAtoi(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        int index = 0;
        char[] chars = s.toCharArray();
        while (index < n && chars[index] == ' ') {
            index++;
        }
        if (index == n) {
            return 0;
        }
        boolean positive = true;
        if (chars[index] == '+') {
            index++;
        } else if (chars[index] == '-') {
            positive = false;
            index++;
        } else if (!Character.isDigit(chars[index])) {
            return 0;
        }
        int res = 0;
        while (index < n && Character.isDigit(chars[index])) {
            int digit = chars[index] - '0';
            if (res > (Integer.MAX_VALUE - digit) / 10) {
                return positive ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + digit;
            index++;
        }
        return positive ? res : -res;
    }
}
