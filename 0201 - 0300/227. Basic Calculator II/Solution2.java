class Solution2 {
    public static int calculate(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int prevnum = 0;
        int currnum = 0;
        int res = 0;
        char op = '+';
        boolean isNegative = false;
        for (int i = 0; i < len; i++) {
            char currchar = s.charAt(i);
            if (Character.isDigit(currchar)) {
                if (isNegative) {
                    currnum = currnum * 10 - (currchar - '0');
                } else {
                    currnum = currnum * 10 + (currchar - '0');
                }

            }
            if (!Character.isDigit(currchar) && !Character.isWhitespace(currchar) || i == len - 1) {
                isNegative = false;
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
                if (i < len - 1 && s.charAt(i + 1) == '-') {
                    isNegative = true;
                    i++;
                }
                currnum = 0;
            }
        }
        res += prevnum;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(calculate("3+2*2"));
        System.out.println(calculate("3+2*-2"));
        System.out.println(calculate("3+-2*2"));
        System.out.println(calculate("-3+2*2"));
        System.out.println(calculate("3+6/-2"));
        System.out.println(calculate("300+5000/-20"));
        System.out.println(calculate("30+600/-20*-10--20*-10+-1"));
        System.out.println(calculate("30+49/-7*-6--21*-3+-1"));
    }
}
