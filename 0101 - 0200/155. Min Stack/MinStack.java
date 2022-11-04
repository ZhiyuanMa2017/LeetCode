class MinStack {
    private Node head;

    class Node {
        int val;
        int min;
        Node next;

        Node(int v, int m, Node n) {
            val = v;
            min = m;
            next = n;
        }
    }

    public MinStack() {
    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            int curMin = Math.min(val, head.min);
            Node newNode = new Node(val, curMin, head);
            head = newNode;
        }
    }

    public void pop() {
        head = head.next;
    }

    public int top() {
        return head.val;
    }

    public int getMin() {
        return head.min;
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
