class Solution {
    public ListNode deleteDuplicatesUnsorted(ListNode head) {
        int[] count = new int[100001];
        ListNode cur = head;
        while (cur != null) {
            count[cur.val]++;
            cur = cur.next;
        }
        ListNode sentinel = new ListNode(-1);
        ListNode pre = sentinel;
        while (head != null) {
            if (count[head.val] == 1) {
                pre.next = head;
                pre = pre.next;
            }
            head = head.next;
        }
        pre.next = null;
        return sentinel.next;
    }
}
