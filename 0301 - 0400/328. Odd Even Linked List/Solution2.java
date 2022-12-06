class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode odd = new ListNode(-1);
        ListNode even = new ListNode(-1);
        ListNode curOdd = odd;
        ListNode curEven = even;
        ListNode cur = head;
        int count = 1;
        while (cur != null) {
            ListNode next = cur.next;
            cur.next = null;
            if (count % 2 == 1) {
                curOdd.next = cur;
                curOdd = curOdd.next;
            } else {
                curEven.next = cur;
                curEven = curEven.next;
            }
            cur = next;
            count++;
        }
        curOdd.next = even.next;
        return odd.next;
    }
}
