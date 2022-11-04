class Solution {
    int curSum = 0;

    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return null;
        }
        convertBST(root.right);
        curSum += root.val;
        root.val = curSum;
        convertBST(root.left);
        return root;
    }
}
