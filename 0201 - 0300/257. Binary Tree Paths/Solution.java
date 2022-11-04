import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res;

    public List<String> binaryTreePaths(TreeNode root) {
        res = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return res;
    }

    private void dfs(TreeNode root, StringBuilder sb) {
        if (sb.length() != 0) {
            sb.append("->");
        }
        sb.append(root.val);
        if (root.left == null && root.right == null) {
            res.add(sb.toString());
        }
        if (root.left != null) {
            dfs(root.left, new StringBuilder(sb));
        }
        if (root.right != null) {
            dfs(root.right, new StringBuilder(sb));
        }
    }
}
