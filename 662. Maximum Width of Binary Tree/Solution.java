import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        int res = 0;
        Queue<Node> q = new LinkedList<>();
        q.offer(new Node(root, 0));
        while (!q.isEmpty()) {
            int size = q.size();
            int min = 0;
            int max = 0;
            for (int i = 0; i < size; i++) {
                Node cur = q.poll();
                if (cur.t.left != null) {
                    q.offer(new Node(cur.t.left, cur.p * 2));
                }
                if (cur.t.right != null) {
                    q.offer(new Node(cur.t.right, cur.p * 2 + 1));
                }
                if (i == 0) {
                    min = cur.p;
                }
                if (i == size - 1) {
                    max = cur.p;
                }
            }
            res = Math.max(res, max - min + 1);
        }
        return res;
    }

    class Node {
        TreeNode t;
        int p;

        Node(TreeNode treeNode, int i) {
            t = treeNode;
            p = i;
        }
    }
}
