class Solution {
    int res;

    public int sumNumbers(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int val) {
        val = val * 10 + node.val;
        if (node.left == null && node.right == null) {
            res += val;
        }
        if (node.left != null) {
            dfs(node.left, val);
        }
        if (node.right != null) {
            dfs(node.right, val);
        }
    }
}
