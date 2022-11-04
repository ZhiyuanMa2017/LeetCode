class Solution {
    int res;

    public int distributeCoins(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        res += Math.abs(l) + Math.abs(r);
        int need = 1 - root.val;
        return l + r - need;
    }
}
