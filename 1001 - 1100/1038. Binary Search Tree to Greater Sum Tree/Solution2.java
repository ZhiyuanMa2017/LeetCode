class Solution {
    int rightSum = 0;

    public TreeNode bstToGst(TreeNode root) {
        if (root == null) {
            return root;
        }
        bstToGst(root.right);
        rightSum += root.val;
        root.val = rightSum;
        bstToGst(root.left);
        return root;
    }
}
