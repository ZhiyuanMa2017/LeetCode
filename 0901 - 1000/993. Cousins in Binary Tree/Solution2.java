class Solution2 {
    int xDepth;
    int yDepth;
    TreeNode xParent;
    TreeNode yParent;

    public boolean isCousins(TreeNode root, int x, int y) {
        xDepth = -1;
        yDepth = -2;
        xParent = null;
        yParent = null;
        dfs(root, x, y, null, 0);
        return xDepth == yDepth && xParent != yParent;
    }

    private void dfs(TreeNode node, int x, int y, TreeNode parent, int depth) {
        if (node == null) {
            return;
        }
        if (node.val == x) {
            xDepth = depth;
            xParent = parent;
        } else if (node.val == y) {
            yDepth = depth;
            yParent = parent;
        } else {
            dfs(node.left, x, y, node, depth + 1);
            dfs(node.right, x, y, node, depth + 1);
        }
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
