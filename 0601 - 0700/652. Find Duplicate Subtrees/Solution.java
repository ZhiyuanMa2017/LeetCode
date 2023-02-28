import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> res = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        dfs(root, map, res);
        return res;
    }

    private StringBuilder dfs(TreeNode root, Map<String, Integer> map, List<TreeNode> res) {
        if (root == null) {
            return new StringBuilder(" ");
        }
        StringBuilder cur = new StringBuilder();
        cur.append(root.val).append("-").append(dfs(root.left, map, res)).append(dfs(root.right, map, res));
        String key = cur.toString();
        map.merge(key, 1, Integer::sum);
        if (map.get(key) == 2) {
            res.add(root);
        }
        return cur;
    }
}
