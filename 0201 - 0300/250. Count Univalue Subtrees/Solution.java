class Solution {
    int count;

    public int countUnivalSubtrees(TreeNode root) {
        count = 0;
        helper(root);
        return count;
    }

    private boolean helper(TreeNode root) {
        if (root == null) {
            return true;
        }
        boolean left = helper(root.left);
        boolean right = helper(root.right);
        if (left && right) {
            if ((root.left == null || root.val == root.left.val) && (root.right == null || root.val == root.right.val)) {
                count++;
                return true;
            }
        }
        return false;
    }
}
