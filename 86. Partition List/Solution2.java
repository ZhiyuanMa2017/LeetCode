class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(-1);
        ListNode greater = new ListNode(-1);
        ListNode curLess = less;
        ListNode curGreater = greater;
        ListNode cur = head;
        ListNode next;
        while (cur != null) {
            next = cur.next;
            if (cur.val < x) {
                cur.next = null;
                curLess.next = cur;
                curLess = curLess.next;
                cur = next;
            } else {
                cur.next = null;
                curGreater.next = cur;
                curGreater = curGreater.next;
                cur = next;
            }
        }
        curLess.next = greater.next;
        return less.next;
    }
}
