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
    public void recoverTree(TreeNode root) {
        TreeNode first = null;
        TreeNode second = null;
        TreeNode previous = null;
        TreeNode curr = root;
        while (curr != null) {
            if (curr.left == null) {

                if (previous != null && previous.val > curr.val) {
                    if (first == null) {
                        first = previous;
                        second = curr;
                    } else {
                        second = curr;
                    }
                }
                previous = curr;

                curr = curr.right;
            } else {
                TreeNode tmp = curr.left;
                while (tmp.right != null && tmp.right != curr) {
                    tmp = tmp.right;
                }
                if (tmp.right == null) {
                    tmp.right = curr;
                    curr = curr.left;
                } else {
                    tmp.right = null;

                    if (previous != null && previous.val > curr.val) {
                        if (first == null) {
                            first = previous;
                            second = curr;
                        } else {
                            second = curr;
                        }
                    }
                    previous = curr;

                    curr = curr.right;
                }
            }
        }
        if (first != null && second != null) {
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }
    }
    // Morris Traversal
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