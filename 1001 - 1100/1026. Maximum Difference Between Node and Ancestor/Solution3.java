class Solution {
    int res;

    public int maxAncestorDiff(TreeNode root) {
        res = 0;
        dfs(root, root.val, root.val);
        return res;
    }

    private void dfs(TreeNode root, int max, int min) {
        if (root == null) {
            return;
        }
        res = Math.max(res, Math.abs(max - root.val));
        res = Math.max(res, Math.abs(min - root.val));
        max = Math.max(root.val, max);
        min = Math.min(root.val, min);
        dfs(root.left, max, min);
        dfs(root.right, max, min);
    }
}
