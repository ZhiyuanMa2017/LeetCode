class Solution {
    public TreeNode reverseOddLevels(TreeNode root) {
        dfs(root.left, root.right, true);
        return root;
    }

    private void dfs(TreeNode left, TreeNode right, boolean isOdd) {
        if (left == null) {
            return;
        }
        if (isOdd) {
            int tmp = left.val;
            left.val = right.val;
            right.val = tmp;
        }
        dfs(left.right, right.left, !isOdd);
        dfs(left.left, right.right, !isOdd);
    }
}
