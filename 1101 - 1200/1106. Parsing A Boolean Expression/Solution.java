import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean parseBoolExpr(String expression) {
        Deque<Character> ops = new ArrayDeque<>();
        Deque<Integer> nums = new ArrayDeque<>();
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == ',') {
                continue;
            } else if (c == 't') {
                nums.push(1);
            } else if (c == 'f') {
                nums.push(0);
            } else if (c == '&' || c == '|' || c == '!') {
                ops.push(c);
            } else if (c == '(') {
                nums.push(2);
            } else if (c == ')') {
                char op = ops.pop();
                int[] count = new int[2];
                while (!nums.isEmpty() && nums.peek() != 2) {
                    count[nums.pop()]++;
                }
                int cur = cal(count, op);
                nums.pop();
                nums.push(cur);
            }
        }
        return nums.peek() == 1;
    }

    private int cal(int[] count, char op) {
        if (op == '&') {
            return count[0] == 0 ? 1 : 0;
        } else if (op == '|') {
            return count[1] == 1 ? 1 : 0;
        } else if (op == '!') {
            return cal(count, '&') ^ 1;
        }
        return 0;
    }
}
