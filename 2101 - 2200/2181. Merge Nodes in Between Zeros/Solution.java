class Solution {
    public ListNode mergeNodes(ListNode head) {
        int count = 0;
        ListNode cur = head.next;
        ListNode pre = head;
        while (cur != null) {
            if (cur.val == 0) {
                pre.next = new ListNode(count);
                pre = pre.next;
                count = 0;
            } else {
                count += cur.val;
            }
            cur = cur.next;
        }
        return head.next;
    }
}
