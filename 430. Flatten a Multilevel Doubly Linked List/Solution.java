class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node cur = head;
        while (cur != null) {
            if (cur.child == null) {
                cur = cur.next;
            } else {
                Node tail = cur.child;
                while (tail.next != null) {
                    tail = tail.next;
                }
                tail.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = tail;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
                cur = cur.next;
            }
        }
        return head;
    }
}
