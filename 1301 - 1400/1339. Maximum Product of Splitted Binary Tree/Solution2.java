class Solution {

    long res;
    long total;

    public int maxProduct(TreeNode root) {
        int mod = 1000000007;
        total = dfs(root);
        res = 0;
        dfs2(root);
        return (int) (res % mod);
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long l = dfs(root.left);
        long r = dfs(root.right);
        return l + r + root.val;
    }

    private long dfs2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long l = dfs2(root.left);
        long r = dfs2(root.right);
        long sub = l + r + root.val;
        res = Math.max(res, (total - sub) * sub);
        return sub;
    }
}
