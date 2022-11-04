class MinStack20211024 {

    Node head;

    class Node {
        int val;
        int min;
        Node next;

        Node(int value, int m, Node node) {
            this.val = value;
            min = m;
            next = node;
        }
    }

    public MinStack20211024() {

    }

    public void push(int val) {
        if (head == null) {
            head = new Node(val, val, null);
        } else {
            int curMin = Math.min(head.min, val);
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
