class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode tempnext = head.next;
        ListNode newhead = reverseList(tempnext);
        tempnext.next = head;
        head.next = null;
        return newhead;
    }
}
