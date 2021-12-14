class Solution20211213 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        if (root.val < low) {
            int r = rangeSumBST(root.right, low, high);
            return r;
        }
        if (root.val > high) {
            int l = rangeSumBST(root.left, low, high);

            return l;
        }
        int l = rangeSumBST(root.left, low, high);
        int r = rangeSumBST(root.right, low, high);
        return l + r + root.val;
    }
}
