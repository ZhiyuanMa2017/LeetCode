import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int sumNumbers(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    cur.left.val += cur.val * 10;
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    cur.right.val += cur.val * 10;
                    queue.offer(cur.right);
                }
                if (cur.left == null && cur.right == null) {
                    res += cur.val;
                }
            }
        }
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
