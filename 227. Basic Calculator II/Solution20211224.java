class Solution20211224 {
    public int calculate(String s) {
        int res = 0;
        int prev = 0;
        int cur = 0;
        char op = '+';
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                cur = cur * 10 + c - '0';
            }
            if (!Character.isDigit(c) && c != ' ' || i == s.length() - 1) {
                if (op == '+') {
                    res += prev;
                    prev = cur;
                } else if (op == '-') {
                    res += prev;
                    prev = -cur;
                } else if (op == '*') {
                    prev *= cur;
                } else if (op == '/') {
                    prev /= cur;
                }
                op = c;
                cur = 0;
            }
        }
        res += prev;
        return res;
    }
}
