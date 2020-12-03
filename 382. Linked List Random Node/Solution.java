import java.util.List;
import java.util.Random;

class Solution {
    ListNode head;
    Random rand;
    /**
     * @param head The linked list's head.
     *             Note that the head is guaranteed to be not null, so it contains at least one node.
     */
    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
    }

    /**
     * Returns a random node's value.
     */
    public int getRandom() {
        ListNode cur = head;
        int res = 0;
        int count = 0;
        while (cur != null)  {
            if (rand.nextInt(count + 1) == count) {
                res = cur.val;
            }
            cur = cur.next;
            count++;
        }
        return res;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(head);
 * int param_1 = obj.getRandom();
 */
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