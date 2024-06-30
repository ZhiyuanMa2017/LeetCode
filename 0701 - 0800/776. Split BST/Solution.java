class Solution {

    public TreeNode[] splitBST(TreeNode root, int target) {
        TreeNode[] res = new TreeNode[2];
        if (root == null) {
            return res;
        }
        if (root.val <= target) {
            res[0] = root;
            TreeNode[] r = splitBST(root.right, target);
            root.right = r[0];
            res[1] = r[1];
        } else {
            res[1] = root;
            TreeNode[] l = splitBST(root.left, target);
            root.left = l[1];
            res[0] = l[0];
        }
        return res;
    }
}
