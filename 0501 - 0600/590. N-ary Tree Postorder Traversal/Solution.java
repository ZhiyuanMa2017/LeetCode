import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> postorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Deque<Node> deque = new ArrayDeque<>();
        deque.add(root);
        Node cur;
        while (!deque.isEmpty()) {
            cur = deque.poll();
            res.add(cur.val);
            for (Node child : cur.children) {
                deque.push(child);
            }
        }
        Collections.reverse(res);
        return res;
    }

    class Node {
        int val;
        List<Node> children;

        Node() {
        }

        Node(int v) {
            val = v;
        }

        Node(int v, List<Node> c) {
            val = v;
            children = c;
        }
    }
}
