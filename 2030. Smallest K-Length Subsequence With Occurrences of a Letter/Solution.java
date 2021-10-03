import java.util.Stack;

class Solution {
    public String smallestSubsequence(String s, int k, char letter, int repetition) {
        int count = 0;
        for (char c : s.toCharArray()) {
            count += c == letter ? 1 : 0;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            while (!stack.isEmpty() && stack.peek() > c && (s.length() - i + stack.size() > k)
                    && (stack.peek() != letter || count > repetition)) {
                if (stack.pop() == letter) {
                    repetition++;
                }
            }
            if (stack.size() < k) {
                if (c == letter) {
                    stack.push(c);
                    repetition--;
                } else if (k - stack.size() - repetition > 0) {
                    stack.push(c);
                }
            }
            if (c == letter) {
                count--;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Character c : stack) {
            sb.append(c);
        }
        return sb.toString();
    }
}
