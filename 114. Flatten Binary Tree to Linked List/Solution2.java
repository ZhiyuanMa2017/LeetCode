class Solution {
    TreeNode pre;

    public void flatten(TreeNode root) {
        dfs(root);
    }

    private TreeNode dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        if (pre != null) {
            pre.right = root;
        }
        pre = root;
        TreeNode right = root.right;
        TreeNode left = root.left;
        root.left = null;
        root.right = null;
        dfs(left);
        pre.right = dfs(right);
        return root;
    }
}
