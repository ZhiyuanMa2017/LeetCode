import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public TreeNode findNearestRightNode(TreeNode root, TreeNode u) {
        Queue<TreeNode> q = new LinkedList<>();
        boolean find = false;
        q.offer(root);
        while (!q.isEmpty()) {
            if (find) {
                return null;
            }
            int size = q.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = q.poll();
                if (find) {
                    return cur;
                }
                if (cur == u) {
                    find = true;
                }
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
        return null;
    }
}
