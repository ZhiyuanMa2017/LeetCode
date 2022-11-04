import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        int step = 0;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<TreeNode> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                level.add(cur);
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            if (step % 2 == 1) {
                int i = 0;
                int j = level.size() - 1;
                while (i < j) {
                    int tmp = level.get(i).val;
                    level.get(i).val = level.get(j).val;
                    level.get(j).val = tmp;
                    i++;
                    j--;
                }
            }
            step++;
        }
        return root;
    }
}
