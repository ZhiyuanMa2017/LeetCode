public class Solution2 {
    public boolean isPalindrome(ListNode head) {
        ListNode fast = head, slow = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        if (fast != null) { // odd nodes, so let slow begin at middle + 1
            slow = slow.next;
        }
        // reverse List begin at slow
        ListNode pre = null;
        while (slow != null) {
            ListNode next = slow.next;
            slow.next = pre;
            pre = slow;
            slow = next;
        }
        fast = head;
        while (pre != null) {
            if (fast.val != pre.val) {
                return false;
            }
            pre = pre.next;
            fast = fast.next;
        }
        return true;
    }
}
