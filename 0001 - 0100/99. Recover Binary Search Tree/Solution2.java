class Solution2 {

    TreeNode first;
    TreeNode second;
    TreeNode pre;

    public void recoverTree(TreeNode root) {
        first = null;
        second = null;
        pre = null;
        dfs(root);
        int tmp = first.val;
        first.val = second.val;
        second.val = tmp;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (first == null && pre != null && pre.val >= root.val) {
            first = pre;
        }
        if (first != null && pre.val >= root.val) {
            second = root;
        }
        pre = root;
        dfs(root.right);
    }
}
