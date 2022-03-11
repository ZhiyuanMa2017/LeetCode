class Solution2 {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || k == 0 || head.next == null) {
            return head;
        }
        int len = 0;
        ListNode cur = head;
        ListNode tail = new ListNode(-1);
        tail.next = cur;
        while (cur != null) {
            len++;
            cur = cur.next;
            tail = tail.next;
        }
        k = k % len;
        if (k == 0) {
            return head;
        }
        cur = head;
        k = len - k;
        while (k > 1) {
            k--;
            cur = cur.next;
        }
        ListNode returnNode = cur.next;
        cur.next = null;
        tail.next = head;
        return returnNode;
    }
}
