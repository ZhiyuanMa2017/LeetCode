class Solution {

    int count;
    int res;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        res = -1;
        inOrder(root);
        return res;
    }

    private void inOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        count--;
        if (count == 0) {
            res = root.val;
            return;
        }
        inOrder(root.right);
        System.out.println();
    }
}
