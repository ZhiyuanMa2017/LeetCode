class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return topDown(root, root.val, root.val);
    }

    public int topDown(TreeNode root, int maxnum, int minnum) {
        if (root == null) {
            return maxnum - minnum;
        } else {
            maxnum = Math.max(root.val, maxnum);
            minnum = Math.min(root.val, minnum);
            return Math.max(topDown(root.left, maxnum, minnum), topDown(root.right, maxnum, minnum));
        }
    }
}
