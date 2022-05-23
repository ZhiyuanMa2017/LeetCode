import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        StringBuilder expression = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (!Character.isWhitespace(s.charAt(i))) {
                expression.append(s.charAt(i));
            }
        }
        StringBuilder sb = new StringBuilder();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            if (expression.charAt(i) == '(') {
                stack.push(sb);
                sb = new StringBuilder();
            } else if (expression.charAt(i) == ')') {
                int cur = cal(sb);
                StringBuilder prev = stack.pop();
                prev.append(cur);
                sb = prev;
            } else {
                sb.append(expression.charAt(i));
            }
        }
        return cal(sb);
    }

    private int cal(StringBuilder sb) {
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
