import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode list : lists) {
            if (list != null) {
                pq.add(list);
            }
        }
        ListNode sentinel = new ListNode(-1);
        ListNode cur = sentinel;
        while (!pq.isEmpty()) {
            ListNode listNode = pq.poll();
            cur.next = listNode;
            cur = cur.next;
            if (listNode.next != null) {
                pq.offer(listNode.next);
            }
        }
        return sentinel.next;
    }
}
