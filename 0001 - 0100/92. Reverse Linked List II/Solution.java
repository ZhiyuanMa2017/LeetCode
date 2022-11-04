class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode sentinel = new ListNode();
        sentinel.next = head;
        ListNode ahead = sentinel;
        int counter = 0;
        while (counter < left - 1) {
            ahead = ahead.next;
            counter++;
        }
        ListNode begin = ahead.next;
        ListNode second = begin.next;

        while (counter < right - 1) {
            begin.next = second.next;
            second.next = ahead.next;
            ahead.next = second;
            second = begin.next;
            counter++;
        }
        return sentinel.next;
        // 1 2 3 4 5
        // a b s
        // 1 3 2 4 5
        // a   b s
    }

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
