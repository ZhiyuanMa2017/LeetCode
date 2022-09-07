import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String reverseParentheses(String s) {
        StringBuilder sb = new StringBuilder();
        Deque<StringBuilder> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.add(sb);
                sb = new StringBuilder();
            } else if (s.charAt(i) == ')') {
                StringBuilder prev = stack.pollLast();
                sb = prev.append(sb.reverse());
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
