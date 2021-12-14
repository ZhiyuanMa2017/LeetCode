import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagIterator {
    Deque<Integer> deque;


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        deque = new LinkedList<>();
        int len = Math.min(v1.size(), v2.size());
        int index = 0;
        while (index < len) {
            deque.add(v1.get(index));
            deque.add(v2.get(index));
            index++;
        }
        while (index < v1.size()) {
            deque.add(v1.get(index));
            index++;
        }
        while (index < v2.size()) {
            deque.add(v2.get(index));
            index++;
        }
    }

    public int next() {
        return deque.pollFirst();
    }

    public boolean hasNext() {
        return !deque.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
