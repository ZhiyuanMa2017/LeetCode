class Solution {
    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = head;
        ListNode lessHead = null;
        ListNode greaterHead = null;
        ListNode lessCur = null;
        ListNode greaterCur = null;

        while (cur != null) {
            if (cur.val < x) {
                if (lessHead == null) {
                    lessHead = cur;
                    cur = cur.next;
                    lessHead.next = null;
                    lessCur = lessHead;
                } else {
                    lessCur.next = cur;
                    cur = cur.next;
                    lessCur = lessCur.next;
                    lessCur.next = null;
                }
            } else {
                if (greaterHead == null) {
                    greaterHead = cur;
                    cur = cur.next;
                    greaterHead.next = null;
                    greaterCur = greaterHead;
                } else {
                    greaterCur.next = cur;
                    cur = cur.next;
                    greaterCur = greaterCur.next;
                    greaterCur.next = null;
                }
            }
        }
        if (lessHead != null) {
            lessCur.next = greaterHead;
            return lessHead;
        } else {
            return greaterHead;
        }
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
