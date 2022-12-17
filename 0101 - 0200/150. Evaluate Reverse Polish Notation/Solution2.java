import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for (String token : tokens) {
            if (token.equals("*") || token.equals("+") || token.equals("-") || token.equals("/")) {
                int two = stack.pop();
                int one = stack.pop();
                switch (token) {
                    case "*" -> one *= two;
                    case "+" -> one += two;
                    case "-" -> one -= two;
                    case "/" -> one /= two;
                }
                stack.push(one);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }
}
