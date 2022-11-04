import java.util.Stack;

class MinStack2 {
    Stack<int[]> s;

    public MinStack2() {
        s = new Stack<>();
    }

    public void push(int val) {
        if (s.isEmpty()) {
            s.push(new int[]{val, val});
        } else {
            int curMin = s.peek()[1];
            curMin = Math.min(curMin, val);
            s.push(new int[]{val, curMin});
        }
    }

    public void pop() {
        s.pop();
    }

    public int top() {
        int[] vals = s.peek();
        return vals[0];
    }

    public int getMin() {
        int[] vals = s.peek();
        return vals[1];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
