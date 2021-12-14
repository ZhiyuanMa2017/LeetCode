import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ZigzagIterator2 {
    Queue<Iterator<Integer>> queue;


    public ZigzagIterator(List<Integer> v1, List<Integer> v2) {
        queue = new LinkedList<>();
        if (!v1.isEmpty()) {
            queue.add(v1.iterator());
        }
        if (!v2.isEmpty()) {
            queue.add(v2.iterator());
        }
    }

    public int next() {
        Iterator<Integer> iterator = queue.poll();
        int res = iterator.next();
        if (iterator.hasNext()) {
            queue.offer(iterator);
        }
        return res;
    }

    public boolean hasNext() {
        return !queue.isEmpty();
    }
}

/**
 * Your ZigzagIterator object will be instantiated and called as such:
 * ZigzagIterator i = new ZigzagIterator(v1, v2);
 * while (i.hasNext()) v[f()] = i.next();
 */
