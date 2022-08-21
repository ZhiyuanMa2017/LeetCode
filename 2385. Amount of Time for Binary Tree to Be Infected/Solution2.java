import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {

    public int amountOfTime(TreeNode root, int start) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        build(root, graph);
        Queue<Integer> queue = new LinkedList<>();
        int level = 0;
        Set<Integer> visited = new HashSet<>();
        visited.add(start);
        queue.offer(start);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                for (Integer next : graph.get(cur)) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        queue.offer(next);
                    }
                }
            }
            level++;
        }
        return level - 1;
    }

    private void build(TreeNode root, Map<Integer, List<Integer>> graph) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (!graph.containsKey(cur.val)) {
                graph.put(cur.val, new ArrayList<>());
            }
            if (cur.left != null) {
                graph.get(cur.val).add(cur.left.val);
                queue.offer(cur.left);
                if (!graph.containsKey(cur.left.val)) {
                    graph.put(cur.left.val, new ArrayList<>());
                }
                graph.get(cur.left.val).add(cur.val);
            }
            if (cur.right != null) {
                graph.get(cur.val).add(cur.right.val);
                queue.offer(cur.right);
                if (!graph.containsKey(cur.right.val)) {
                    graph.put(cur.right.val, new ArrayList<>());
                }
                graph.get(cur.right.val).add(cur.val);
            }
        }
    }
}
