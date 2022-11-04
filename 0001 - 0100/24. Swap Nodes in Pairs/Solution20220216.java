class Solution20220216 {
    public ListNode swapPairs(ListNode head) {
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        ListNode pre = sentinel;
        while (pre.next != null && pre.next.next != null) {
            ListNode front = pre.next;
            ListNode rear = front.next;

            pre.next = rear;
            front.next = rear.next;
            rear.next = front;
            pre = front;
        }
        return sentinel.next;
    }
}
