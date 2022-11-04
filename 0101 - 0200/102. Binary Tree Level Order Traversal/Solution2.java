import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<List<Integer>> res;

    public List<List<Integer>> levelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth - 1).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
