class Solution {
    private int in = 0;
    private int pre = 0;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return builder(preorder, inorder, Integer.MIN_VALUE);
    }

    private TreeNode builder(int[] preorder, int[] inorder, int end) {
        if (pre >= preorder.length) {
            return null;
        }
        if (inorder[in] == end) {
            in++;
            return null;
        }
        TreeNode node = new TreeNode(preorder[pre]);
        pre++;
        node.left = builder(preorder, inorder, node.val);
        node.right = builder(preorder, inorder, end);
        return node;
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
