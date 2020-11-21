import com.sun.source.tree.BreakTree;

import java.sql.PreparedStatement;
import java.util.List;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode[] result = new ListNode[k];
        int len = 0;
        ListNode head = root;
        while (head != null) {
            len++;
            head = head.next;
        }
        int lenthofeach = len / k;
        int mod = len % k;
        ListNode curr = root;
        for (int i = 0; i < k; i++) {
            if (curr == null) {
                break;
            }
            result[i] = curr;
            int thislenth = 0;
            if (mod > 0) {
                thislenth = lenthofeach + 1;
                mod--;
            } else {
                thislenth = lenthofeach;
            }
            for (int i1 = 0; i1 < thislenth - 1; i1++) {
                curr = curr.next;
            }
            ListNode tmp = curr.next;
            curr.next = null;
            curr = tmp;
        }
        return result;
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