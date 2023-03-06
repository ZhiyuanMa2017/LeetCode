import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        List<Long> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            long cur = 0;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                cur += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            list.add(cur);
        }
        if (list.size() < k) {
            return -1;
        }
        Collections.sort(list);
        Collections.reverse(list);
        return list.get(k - 1);
    }
}
