/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public int maxAncestorDiff(TreeNode root) {
        return TopDown(root, root.val, root.val);
    }

    public int TopDown(TreeNode root, int maxnum, int minnum) {
        if (root == null) {
            return maxnum - minnum;
        } else {
            maxnum = Math.max(root.val, maxnum);
            minnum = Math.min(root.val, minnum);
            return Math.max(TopDown(root.left, maxnum, minnum), TopDown(root.right, maxnum, minnum));
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