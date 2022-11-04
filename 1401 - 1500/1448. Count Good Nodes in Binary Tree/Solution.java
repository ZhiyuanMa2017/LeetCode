class Solution {
    public int goodNodes(TreeNode root) {
        return helper(root, -10000);
    }

    private int helper(TreeNode node, int curMax) {
        if (node == null) {
            return 0;
        }
        int res = node.val < curMax ? 0 : 1;
        res += helper(node.left, Math.max(curMax, node.val));
        res += helper(node.right, Math.max(curMax, node.val));
        return res;
    }

    class TreeNode {
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
