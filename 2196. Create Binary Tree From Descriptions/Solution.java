import java.util.HashMap;
import java.util.Map;

class Solution {
    public TreeNode createBinaryTree(int[][] descriptions) {
        Map<Integer, Integer> indegree = new HashMap<>();
        Map<Integer, TreeNode> map = new HashMap<>();
        for (int[] description : descriptions) {
            int p = description[0];
            int c = description[1];
            int left = description[2];
            if (!map.containsKey(p)) {
                map.put(p, new TreeNode(p));
            }
            TreeNode pnode = map.get(p);
            if (!map.containsKey(c)) {
                map.put(c, new TreeNode(c));
            }
            TreeNode cnode = map.get(c);
            if (left == 1) {
                pnode.left = cnode;
            } else {
                pnode.right = cnode;
            }
            indegree.put(c, indegree.getOrDefault(c, 0) + 1);
            indegree.put(p, indegree.getOrDefault(p, 0));
        }
        for (Integer key : indegree.keySet()) {
            if (indegree.get(key) == 0) {
                return map.get(key);
            }
        }
        return null;
    }
}
