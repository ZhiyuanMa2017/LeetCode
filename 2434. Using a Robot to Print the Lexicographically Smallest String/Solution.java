import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String robotWithString(String s) {
        int n = s.length();
        char[] nextMinChars = new char[s.length()];
        nextMinChars[n - 1] = s.charAt(s.length() - 1);
        for (int i = n - 2; i >= 0; i--) {
            nextMinChars[i] = (char) Math.min(nextMinChars[i + 1], s.charAt(i));
        }
        StringBuilder res = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            while (!stack.isEmpty() && stack.peek() <= nextMinChars[i]) {
                res.append(stack.pop());
            }
            stack.push(c);
        }
        while (!stack.isEmpty()) {
            res.append(stack.pop());
        }
        return res.toString();
    }
}
