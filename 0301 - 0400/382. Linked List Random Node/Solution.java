import java.util.Random;

class Solution {
    ListNode head;
    Random rand;

    public Solution(ListNode head) {
        rand = new Random();
        this.head = head;
    }

    public int getRandom() {
        ListNode cur = head;
        int res = 0;
        int count = 0;
        while (cur != null) {
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
