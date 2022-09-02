import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> count = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            double cur = 0;
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
            res.add(cur);
            count.add(size);
        }
        int n = res.size();
        for (int i = 0; i < n; i++) {
            res.set(i, res.get(i) / count.get(i));
        }
        return res;
    }
}
