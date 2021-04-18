public class Solution20210418 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        while (n > 0) {
            n--;
            fast = fast.next;
        }
        // a-b-c-d-e-null   n=5: remove a
        //           ↑
        //          fast
        //

        // a-b-c-d-e   n=2: remove d
        //     ↑
        //    fast

        // a-b-c-d-e   n=2: remove d
        //     ↑   ↑
        //   slow  fast
        // fast move to the last one, so slow move to the font node of the remove target

        if (fast == null) {
            return head.next;
        } else {
            ListNode slow = head;
            while (fast.next != null) {
                slow = slow.next;
                fast = fast.next;
            }
            slow.next = slow.next.next;
            return head;
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
