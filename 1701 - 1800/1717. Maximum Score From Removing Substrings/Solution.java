import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        char[] chars = new char[]{'a', 'b'};
        int large = x;
        int small = y;
        if (x < y) {
            chars = new char[]{'b', 'a'};
            large = y;
            small = x;
        }
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c == chars[1] && !deque.isEmpty() && deque.peekLast() == chars[0]) {
                deque.pollLast();
                res += large;
            } else {
                deque.addLast(c);
            }
        }
        Deque<Character> deque2 = new ArrayDeque<>();
        while (!deque.isEmpty()) {
            char c = deque.pollLast();
            if (c == chars[0] && !deque2.isEmpty() && deque2.peekLast() == chars[1]) {
                deque2.pollLast();
                res += small;
            } else {
                deque2.addLast(c);
            }
        }
        return res;
    }
}
