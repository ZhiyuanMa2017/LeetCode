import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() <= k) {
            return "0";
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : num.toCharArray()) {
            while (!deque.isEmpty() && k > 0 && deque.peekLast() > c) {
                deque.removeLast();
                k--;
            }
            deque.addLast(c);
        }
        while (!deque.isEmpty() && k > 0) {
            deque.removeLast();
            k--;
        }
        StringBuilder sb = new StringBuilder();
        boolean notZero = false;
        for (Character c : deque) {
            if (c == '0' && !notZero) {
                continue;
            }
            if (c != '0') {
                notZero = true;
            }
            sb.append(c);
        }
        return sb.length() > 0 ? sb.toString() : "0";
    }
}
