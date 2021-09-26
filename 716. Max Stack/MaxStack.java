import java.util.Stack;

class MaxStack {
    Stack<Integer> stack;
    Stack<Integer> maxStack;

    /**
     * initialize your data structure here.
     */
    public MaxStack() {
        stack = new Stack<>();
        maxStack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (maxStack.isEmpty()) {
            maxStack.push(x);
        } else {
            int prevMax = maxStack.peek();
            maxStack.push(Math.max(x, prevMax));
        }
    }

    public int pop() {
        maxStack.pop();
        return stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int peekMax() {
        return maxStack.peek();
    }

    public int popMax() {
        int topMost = peekMax();
        Stack<Integer> tmp = new Stack<>();
        while (top() != topMost) {
            tmp.push(pop());
        }
        pop();
        while (!tmp.isEmpty()) {
            push(tmp.pop());
        }
        return topMost;
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */
