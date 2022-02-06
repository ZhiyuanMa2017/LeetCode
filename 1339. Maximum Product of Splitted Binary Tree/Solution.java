class Solution {
    long res;
    long total;

    public int maxProduct(TreeNode root) {
        res = 0;
        total = dfs(root);
        dfs(root);
        int mod = 1000000007;
        return (int) (res % mod);
    }

    private long dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        long subSum = dfs(root.left) + dfs(root.right) + root.val;
        res = Math.max(res, (total - subSum) * subSum);
        return subSum;
    }
}
