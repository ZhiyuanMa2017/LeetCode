class Solution {
    int res;

    public int sumRootToLeaf(TreeNode root) {
        res = 0;
        dfs(root, 0);
        return res;
    }

    private void dfs(TreeNode node, int cur) {
        cur = cur * 2 + node.val;
        if (node.left == null && node.right == null) {
            res += cur;
            return;
        }

        if (node.left != null) {
            dfs(node.left, cur);
        }
        if (node.right != null) {
            dfs(node.right, cur);
        }

    }
}
