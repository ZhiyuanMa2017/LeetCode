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
                Node curChild = cur.child;
                while (curChild.next != null) {
                    curChild = curChild.next;
                }
                curChild.next = cur.next;
                if (cur.next != null) {
                    cur.next.prev = curChild;
                }
                cur.next = cur.child;
                cur.child.prev = cur;
                cur.child = null;
            }
        }
        return head;
    }

    class Node {
        int val;
        Node prev;
        Node next;
        Node child;
    }
}
