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
class Solution1 {
    public int rangeSumBST(TreeNode root, int low, int high) {
        int sum = 0;
        return helper(root, low, high, sum);
    }
    public int helper(TreeNode root, int low, int high, int sum) {
        if (root == null) {
            return sum;
        }
        if(root.val>=low && root.val<=high) {
            sum += root.val + helper(root.right, low, high, sum)+helper(root.left , low, high, sum);
        } else if(root.val< low && root.right != null){
            sum += helper(root.right, low, high, sum);
        } else if(root.val > high && root.left != null){
            sum += helper(root.left , low, high, sum);
        }
        return sum;
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