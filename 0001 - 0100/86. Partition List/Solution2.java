class Solution2 {
    public ListNode partition(ListNode head, int x) {
        ListNode lessHead = new ListNode(-1);
        ListNode greaterHead = new ListNode(-1);
        ListNode curLess = lessHead;
        ListNode curGreater = greaterHead;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            cur.next = null;
            if (cur.val < x) {
                curLess.next = cur;
                curLess = curLess.next;
            } else {
                curGreater.next = cur;
                curGreater = curGreater.next;
            }
            cur = next;
        }
        curLess.next = greaterHead.next;
        return lessHead.next;
    }
}
