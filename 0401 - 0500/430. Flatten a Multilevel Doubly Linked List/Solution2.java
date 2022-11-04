class Solution {
    public Node flatten(Node head) {
        if (head == null) {
            return null;
        }
        Node sentinel = new Node();
        dfs(sentinel, head);
        head.prev = null;
        return sentinel.next;
    }

    private Node dfs(Node prev, Node cur) {
        if (cur == null) {
            return prev;
        }
        prev.next = cur;
        cur.prev = prev;
        Node next = cur.next;
        Node tail = dfs(cur, cur.child);
        cur.child = null;
        return dfs(tail, next);
    }
}
