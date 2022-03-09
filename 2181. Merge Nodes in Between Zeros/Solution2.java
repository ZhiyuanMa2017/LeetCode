class Solution2 {
    public ListNode mergeNodes(ListNode head) {
        ListNode sentinel = head;
        ListNode cur = head.next;
        int count = 0;
        while (cur != null) {
            if (cur.val == 0) {
                sentinel.next.val = count;
                sentinel = sentinel.next;
                count = 0;
            } else {
                count += cur.val;
            }
            cur = cur.next;
        }
        sentinel.next = null;
        return head.next;

    }
}
