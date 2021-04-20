import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        Stack<Node> s = new Stack<>();
        s.add(root);
        while (!s.isEmpty()) {
            Node tmp = s.pop();
            res.add(tmp.val);
            for (int i = tmp.children.size() - 1; i >= 0; i--) {
                s.add(tmp.children.get(i));
            }
        }
        return res;
    }

    class Node {
        int val;
        List<Node> children;

        Node() {
        }

        Node(int val) {
            val = val;
        }

        Node(int val, List<Node> children) {
            val = val;
            children = children;
        }
    }
}
