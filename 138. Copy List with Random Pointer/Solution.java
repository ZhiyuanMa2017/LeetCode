class Solution {
    public Node copyRandomList(Node head) {
        Node cur = head;
        Node next;
        while (cur != null) {
            next = cur.next;
            Node copy = new Node(cur.val);
            cur.next = copy;
            copy.next = next;

            cur = next;
        }

        cur = head;
        while (cur != null) {
            if (cur.random != null) {
                cur.next.random = cur.random.next;
            }
            cur = cur.next.next;
        }

        cur = head;
        Node sentinel = new Node(0);
        Node res = sentinel;
        Node resnext;
        while (cur != null) {
            next = cur.next.next;

            resnext = cur.next;
            res.next = resnext;
            res = resnext;

            cur.next = next;
            cur = next;

        }
        return sentinel.next;
    }
}
