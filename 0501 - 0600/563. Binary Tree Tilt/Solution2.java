class Solution2 {
    int res;

    public int findTilt(TreeNode root) {
        res = 0;
        helper(root);
        return res;
    }

    private int helper(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = helper(root.left);
        int right = helper(root.right);
        res += Math.abs(left - right);
        return root.val + left + right;

    }
}
