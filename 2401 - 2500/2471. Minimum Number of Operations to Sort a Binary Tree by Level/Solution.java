import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minimumOperations(TreeNode root) {
        int res = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                list.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            res += cal(list);
        }
        return res;
    }

    private int cal(List<Integer> list) {
        int n = list.size();
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.put(list.get(i), i);
        }
        Collections.sort(list);
        boolean[] visited = new boolean[n];
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i] || map.get(list.get(i)) == i) {
                continue;
            }
            int j = i;
            int count = 0;
            while (!visited[j]) {
                visited[j] = true;
                j = map.get(list.get(j));
                count++;
            }
            if (count > 0) {
                res += count - 1;
            }
        }
        return res;
    }
}
