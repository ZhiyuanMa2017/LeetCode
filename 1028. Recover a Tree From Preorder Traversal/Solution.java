import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public TreeNode recoverFromPreorder(String traversal) {
        Deque<Node> stack = new ArrayDeque<>();
        int i = 0;
        while (i < traversal.length()) {
            int depth = 0;
            while (i < traversal.length() && !Character.isDigit(traversal.charAt(i))) {
                i++;
                depth++;
            }
            int start = i;
            while (i < traversal.length() && Character.isDigit(traversal.charAt(i))) {
                i++;
            }
            int num = Integer.parseInt(traversal.substring(start, i));
            TreeNode tn = new TreeNode(num);
            Node cur = new Node(tn, depth);
            if (stack.isEmpty()) {
                stack.push(cur);
            } else {
                while (stack.peek().depth >= depth) {
                    stack.pop();
                }
                Node last = stack.peek();
                if (last.tn.left == null) {
                    last.tn.left = tn;
                } else {
                    last.tn.right = tn;
                }
                stack.push(cur);
            }
        }
        return stack.pollLast().tn;
    }

    class Node {
        TreeNode tn;
        int depth;

        Node(TreeNode n, int i) {
            tn = n;
            depth = i;
        }
    }
}
