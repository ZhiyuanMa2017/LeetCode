import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution2 {
    Map<Integer, List<Integer>> graph;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        graph = new HashMap<>();
        graph.put(root.val, new ArrayList<>());
        dfs(root);
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        queue.offer(target.val);
        boolean[] visited = new boolean[501];
        visited[target.val] = true;
        while (!queue.isEmpty() && k >= 0) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int node = queue.poll();
                if (k == 0) {
                    res.add(node);
                } else {
                    for (Integer next : graph.get(node)) {
                        if (!visited[next]) {
                            queue.offer(next);
                            visited[next] = true;
                        }
                    }
                }
            }
            k--;
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root.left != null) {
            graph.get(root.val).add(root.left.val);
            graph.put(root.left.val, new ArrayList<>());
            graph.get(root.left.val).add(root.val);
            dfs(root.left);
        }
        if (root.right != null) {
            graph.get(root.val).add(root.right.val);
            graph.put(root.right.val, new ArrayList<>());
            graph.get(root.right.val).add(root.val);
            dfs(root.right);
        }
    }
}
