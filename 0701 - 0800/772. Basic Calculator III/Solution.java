import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int calculate(String s) {
        Deque<StringBuilder> stack = new ArrayDeque<>();
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(cur);
                cur = new StringBuilder();
            } else if (s.charAt(i) == ')') {
                int res = cal(cur);
                StringBuilder prev = stack.pop();
                prev.append(res);
                cur = prev;
            } else {
                cur.append(s.charAt(i));
            }
        }
        return cal(cur);
    }

    public int cal(StringBuilder sb) {
        int res = 0;
        int prev = 0;
        int cur = 0;
        int n = sb.length();
        char op = '+';
        boolean isNegative = false;
        for (int i = 0; i < n; i++) {
            char c = sb.charAt(i);
            if (Character.isDigit(c)) {
                if (!isNegative) {
                    cur = cur * 10 + (c - '0');
                } else {
                    cur = cur * 10 - (c - '0');
                }
            }
            if (!Character.isDigit(c) || i == n - 1) {
                isNegative = false;
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
                if (i + 1 < n && sb.charAt(i + 1) == '-') {
                    isNegative = true;
                    i++;
                }
                cur = 0;
            }
        }
        res += prev;
        return res;
    }
}
