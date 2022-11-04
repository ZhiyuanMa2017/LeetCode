class Solution {
    public TreeNode pruneTree(TreeNode root) {
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l && !r && root.val == 0) {
            return null;
        }
        if (!l) {
            root.left = null;
        }
        if (!r) {
            root.right = null;
        }
        return root;
    }

    private boolean dfs(TreeNode root) {
        if (root == null) {
            return false;
        }
        boolean l = dfs(root.left);
        boolean r = dfs(root.right);
        if (!l) {
            root.left = null;
        }
        if (!r) {
            root.right = null;
        }
        return l || r || root.val == 1;
    }
}
