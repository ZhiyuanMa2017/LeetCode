public class Solution20220118 {
    public ListNode detectCycle(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                ListNode sameStep = head;
                while (sameStep != slow) {
                    slow = slow.next;
                    sameStep = sameStep.next;
                }
                return slow;
            }
        }
        return null;
    }
}
