import java.util.ArrayList;
import java.util.List;

class Solution2 {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, "");
        return res;
    }

    private void dfs(TreeNode root, String s) {

        if (root.left == null && root.right == null) {
            res.add(s + root.val);
        }
        if (root.left != null) {
            dfs(root.left, s + root.val + "->");
        }
        if (root.right != null) {
            dfs(root.right, s + root.val + "->");
        }
    }
}
