import java.util.HashSet;
import java.util.Set;

class Solution {
    Set<Integer> set;

    public TreeNode correctBinaryTree(TreeNode root) {
        set = new HashSet<>();
        return dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (root.right != null && set.contains(root.right.val)) {
            return null;
        }
        set.add(root.val);
        root.right = dfs(root.right);
        root.left = dfs(root.left);
        return root;
    }
}
