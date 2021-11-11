class Solution2 {
    public TreeNode upsideDownBinaryTree(TreeNode root) {
        if (root == null || root.left == null) {
            return root;
        }
        TreeNode prev = null;
        TreeNode cur = root;
        TreeNode rightPart = null;
        TreeNode next = null;
        while (cur != null) {
            next = cur.left;
            cur.left = rightPart;
            rightPart = cur.right;
            cur.right = prev;

            prev = cur;
            cur = next;
        }
        return prev;
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
