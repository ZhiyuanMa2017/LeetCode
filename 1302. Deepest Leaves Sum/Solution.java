import java.util.LinkedList;

class Solution {
    public int deepestLeavesSum(TreeNode root) {
        // level traversal
        int res = 0;
        LinkedList<TreeNode> level = new LinkedList<>();
        level.add(root);

        while (!level.isEmpty()) {
            res = 0;
            for (int i = level.size() - 1; i >= 0; i--) {
                TreeNode node = level.poll();
                res += node.val;
                if (node.left != null) {
                    level.add(node.left);
                }
                if (node.right != null) {
                    level.add(node.right);
                }
            }
        }
        return res;
    }
}
