import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public boolean isCompleteTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean gap = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null) {
                    gap = true;
                } else {
                    if (gap) {
                        return false;
                    }
                    queue.offer(node.left);
                }
                if (node.right == null) {
                    gap = true;
                } else {
                    if (gap) {
                        return false;
                    }
                    queue.offer(node.right);
                }
            }
        }
        return true;
    }
}
