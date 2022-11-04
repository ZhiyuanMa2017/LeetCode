class Solution {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int prevnum = 0;
        int currnum = 0;
        int res = 0;
        char op = '+';
        for (int i = 0; i < len; i++) {
            char currchar = s.charAt(i);
            if (Character.isDigit(currchar)) {
                currnum = currnum * 10 + (currchar - '0');
            }
            if (!Character.isDigit(currchar) && !Character.isWhitespace(currchar) || i == len - 1) {
                if (op == '+') {
                    res += prevnum;
                    prevnum = currnum;
                } else if (op == '-') {
                    res += prevnum;
                    prevnum = -currnum;
                } else if (op == '*') {
                    prevnum = prevnum * currnum;
                } else if (op == '/') {
                    prevnum = prevnum / currnum;
                }
                op = currchar;
                currnum = 0;
            }
        }
        res += prevnum;
        return res;
    }
}
