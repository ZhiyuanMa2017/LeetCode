import java.util.HashMap;
import java.util.Map;

class Solution2 {
    Map<Node, Node> map;

    public Node copyRandomList(Node head) {
        map = new HashMap<>();
        return dfs(head);
    }

    private Node dfs(Node head) {
        if (head == null) {
            return null;
        }
        if (map.containsKey(head)) {
            return map.get(head);
        }
        Node newHead = new Node(head.val);
        map.put(head, newHead);
        newHead.next = dfs(head.next);
        newHead.random = dfs(head.random);
        return newHead;
    }
}
