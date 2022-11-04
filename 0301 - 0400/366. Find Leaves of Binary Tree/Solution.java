import java.util.ArrayList;
import java.util.List;

class Solution {
    List<List<Integer>> res;

    public List<List<Integer>> findLeaves(TreeNode root) {
        res = new ArrayList();
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return -1;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int height = Math.max(l, r) + 1;
        if (res.size() == height) {
            res.add(new ArrayList());
        }
        res.get(height).add(root.val);
        return Math.max(l, r) + 1;
    }
}
