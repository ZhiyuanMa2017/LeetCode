import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int longestValidParentheses(String s) {
        Deque<Integer> stack = new ArrayDeque<>();
        int res = 0;
        int prev = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                if (!stack.isEmpty()) {
                    stack.pop();
                    int top = prev;
                    if (!stack.isEmpty()) {
                        top = stack.peek();
                    }
                    res = Math.max(res, i - top);
                } else {
                    prev = i;
                }
            }
        }
        return res;
    }
}
