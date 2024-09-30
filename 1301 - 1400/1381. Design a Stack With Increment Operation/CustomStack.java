import java.util.ArrayDeque;
import java.util.Deque;

class CustomStack {
    int[] incr;
    Deque<Integer> deque;
    int size;

    public CustomStack(int maxSize) {
        incr = new int[maxSize];
        deque = new ArrayDeque<>();
        size = maxSize;
    }

    public void push(int x) {
        if (deque.size() == size) {
            return;
        }
        deque.push(x);
    }

    public int pop() {
        int res = -1;
        int i = deque.size() - 1;
        if (i >= 0) {
            res = deque.pop() + incr[i];
            if (i > 0) {
                incr[i - 1] += incr[i];
            }
            incr[i] = 0;
        }
        return res;
    }

    public void increment(int k, int val) {
        int i = Math.min(deque.size(), k) - 1;
        if (i >= 0) {
            incr[i] += val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */
