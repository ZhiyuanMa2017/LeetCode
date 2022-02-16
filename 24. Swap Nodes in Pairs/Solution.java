class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
        ListNode pre = sentinel;
        while (pre.next != null && pre.next.next != null) {
            ListNode node1 = pre.next;
            ListNode node2 = pre.next.next;
            ListNode nexttmp = node2.next;
            node2.next = node1;
            node1.next = nexttmp;
            pre.next = node2;
            pre = node1;
        }
        return sentinel.next;
    }
}
