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
            int tmp = Math.min(val, head.min);
            Node temp = new Node(val, tmp, head);
            head = temp;
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
