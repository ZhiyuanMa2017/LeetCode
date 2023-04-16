import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int addMinimum(String word) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : word.toCharArray()) {
            if (c == 'a') {
                if (deque.isEmpty() || deque.peekLast() == 'c') {
                    deque.addLast(c);
                } else {
                    if (deque.peekLast() == 'b') {
                        deque.addLast('c');
                    } else if (deque.peekLast() == 'a') {
                        deque.addLast('b');
                        deque.addLast('c');
                    }
                    deque.addLast(c);
                }
            } else if (c == 'b') {
                if (!deque.isEmpty() && deque.peekLast() == 'a') {
                    deque.addLast(c);
                } else {
                    if (deque.isEmpty()) {
                        deque.addLast('a');
                        deque.addLast(c);
                    } else if (deque.peekLast() == 'b') {
                        deque.addLast('c');
                        deque.addLast('a');
                        deque.addLast(c);
                    } else if (deque.peekLast() == 'c') {
                        deque.addLast('a');
                        deque.addLast(c);
                    }
                }
            } else if (c == 'c') {
                if (!deque.isEmpty() && deque.peekLast() == 'b') {
                    deque.addLast(c);
                } else {
                    if (deque.isEmpty()) {
                        deque.addLast('a');
                        deque.addLast('b');
                        deque.addLast(c);
                    } else if (deque.peekLast() == 'a') {
                        deque.addLast('b');
                        deque.addLast(c);
                    } else if (deque.peekLast() == 'c') {
                        deque.addLast('a');
                        deque.addLast('b');
                        deque.addLast(c);
                    }
                }
            }
        }
        if (deque.peekLast() == 'a') {
            return deque.size() + 2 - word.length();
        } else if (deque.peekLast() == 'b') {
            return deque.size() + 1 - word.length();
        } else {
            return deque.size() - word.length();
        }
    }
}
