/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    public TreeNode subtreeWithAllDeepest(TreeNode root) {
        return deep(root).node;
    }
    private Pair deep(TreeNode root) {
        if (root == null) {
            return new Pair(0, null);
        }
        Pair l = deep(root.left);
        Pair r = deep(root.right);
        int ln = l.num;
        int rn = r.num;
        if (ln == rn) {
            return new Pair(ln + 1, root);
        } else if (ln > rn) {
            return new Pair(ln + 1, l.node);
        } else {
            return new Pair(rn + 1, r.node);
        }
    }


    private class Pair {
        int num;
        TreeNode node;
        public Pair(int num, TreeNode node) {
            this.num = num;
            this.node = node;
        }
    }
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
