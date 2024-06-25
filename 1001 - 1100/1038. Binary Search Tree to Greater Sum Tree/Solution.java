class Solution {
    public TreeNode bstToGst(TreeNode root) {
        helper(root, 0);
        return root;
    }

    private int helper(TreeNode root, int rightSum) {
        if (root == null) {
            return rightSum;
        }
        int cur = helper(root.right, rightSum);
        root.val += cur;
        return helper(root.left, root.val);
    }
}
