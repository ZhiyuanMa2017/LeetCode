import java.util.LinkedList;
import java.util.Queue;

class MovingAverage {
    Queue<Integer> q;
    int s;
    int total;

    public MovingAverage(int size) {
        q = new LinkedList<>();
        s = size;
        total = 0;
    }

    public double next(int val) {
        total += val;
        q.offer(val);
        while (q.size() > s) {
            total -= q.poll();
        }
        return (double) total / q.size();
    }
}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */
