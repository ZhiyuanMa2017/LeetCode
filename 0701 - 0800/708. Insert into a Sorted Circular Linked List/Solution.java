class Solution {
    public Node insert(Node head, int insertVal) {
        Node insert = new Node(insertVal);
        if (head == null) {
            insert.next = insert;
            return insert;
        }
        Node cur = head;
        while (cur.next != head) {
            if (cur.val <= cur.next.val) {
                if (cur.val <= insertVal && insertVal <= cur.next.val) {
                    break;
                }
            } else {
                if (cur.val <= insertVal || insertVal <= cur.next.val) {
                    break;
                }
            }
            cur = cur.next;
        }
        Node next = cur.next;
        cur.next = insert;
        insert.next = next;
        return head;
    }
}
