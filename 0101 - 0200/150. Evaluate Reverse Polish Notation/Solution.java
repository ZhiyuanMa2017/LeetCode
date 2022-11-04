import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> integers = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));
        for (String token : tokens) {
            if (!operators.contains(token)) {
                integers.add(Integer.valueOf(token));
            } else {
                int tmp = 0;
                int next = integers.pop();
                int previous = integers.pop();
                if (token.equals("+")) {
                    tmp += previous + next;
                } else if (token.equals("-")) {
                    tmp += previous - next;
                } else if (token.equals("*")) {
                    tmp += previous * next;
                } else if (token.equals("/")) {
                    tmp += previous / next;
                }
                integers.add(tmp);
            }
        }
        return integers.pop();
    }
}
