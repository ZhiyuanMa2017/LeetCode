import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    Map<Integer, TreeNode> parent;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        parent = new HashMap<>();
        dfs(root);
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(target);
        boolean[] visited = new boolean[501];
        visited[target.val] = true;
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (k == 0) {
                    res.add(node.val);
                }
                if (node.left != null && !visited[node.left.val]) {
                    queue.offer(node.left);
                    visited[node.left.val] = true;
                }
                if (node.right != null && !visited[node.right.val]) {
                    queue.offer(node.right);
                    visited[node.right.val] = true;
                }
                if (parent.containsKey(node.val) && !visited[parent.get(node.val).val]) {
                    queue.offer(parent.get(node.val));
                    visited[parent.get(node.val).val] = true;
                }
            }
            k--;
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if (root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }
}
