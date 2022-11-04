import java.util.LinkedList;
import java.util.Queue;

class MyStack {
    Queue<Integer> one;
    Queue<Integer> two;

    public MyStack() {
        one = new LinkedList<>();
        two = new LinkedList<>();
    }

    public void push(int x) {
        while (!one.isEmpty()) {
            two.offer(one.poll());
        }
        one.offer(x);
        while (!two.isEmpty()) {
            one.offer(two.poll());
        }
    }

    public int pop() {
        return one.poll();
    }

    public int top() {
        return one.peek();
    }

    public boolean empty() {
        return one.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
