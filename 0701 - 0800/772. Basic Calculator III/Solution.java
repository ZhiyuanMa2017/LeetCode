import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isWhitespace(c)) {
                continue;
            } else if (c == '(') {
                stack.push(cur);
                cur = new StringBuilder();
            } else if (c == ')') {
                int r = cal(cur);
                StringBuilder prev = stack.pop();
                prev.append(r);
                cur = prev;
            } else {
                cur.append(c);
            }
        }
        return cal(cur);
    }

    public static int cal(StringBuilder sb) {
        int res = 0;
        int prev = 0;
        int cur = 0;
        char op = '+';
        boolean isNegative = false;
        for (int i = 0; i < sb.length(); i++) {
            char c = sb.charAt(i);
            if (Character.isDigit(c)) {
                if (isNegative) {
                    cur = cur * 10 - (c - '0');
                } else {
                    cur = cur * 10 + (c - '0');
                }
            }
            if (!Character.isDigit(c) || i == sb.length() - 1) {
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
                if (i < sb.length() - 1 && sb.charAt(i + 1) == '-') {
                    isNegative = true;
                    i++;
                } else {
                    isNegative = false;
                }
            }
        }
        res += prev;
        return res;
    }
}
