import java.util.Stack;

class Solution2 {
    public int calculate(String s) {
        int num = 0;
        int sign = 1;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                int cur = c - '0';
                while (i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))) {
                    cur = cur * 10 + s.charAt(i + 1) - '0';
                    i++;
                }
                num += cur * sign;
            } else if (c == '+') {
                sign = 1;
            } else if (c == '-') {
                sign = -1;
            } else if (c == '(') {
                stack.push(num);
                stack.push(sign);
                num = 0;
                sign = 1;
            } else if (c == ')') {
                int prevsign = stack.pop();
                int prev = stack.pop();
                num = num * prevsign + prev;
            }
        }
        return num;
    }
}
