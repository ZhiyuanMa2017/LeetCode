import java.util.Stack;

class Solution {
    public int calculate(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                continue;
            } else if (c == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else if (c == ')') {
                int res = cal(sb.toString());
                StringBuilder prev = stack.pop();
                prev.append(res);
                sb = prev;
            } else {
                sb.append(c);
            }
        }
        return cal(sb.toString());
    }

    public static int cal(String s) {
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


}
