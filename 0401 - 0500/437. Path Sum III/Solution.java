import java.util.HashMap;
import java.util.Map;

class Solution {
    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        return dfs(root, sum, 0, map);
    }

    public int dfs(TreeNode root, int sum, int cur, Map<Integer, Integer> preMap) {
        if (root == null) {
            return 0;
        }
        cur += root.val;
        int res = preMap.getOrDefault(cur - sum, 0);
        preMap.put(cur, preMap.getOrDefault(cur, 0) + 1);
        res += dfs(root.left, sum, cur, preMap) + dfs(root.right, sum, cur, preMap);
        preMap.put(cur, preMap.get(cur) - 1);
        return res;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
