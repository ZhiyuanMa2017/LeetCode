import java.util.ArrayList;
import java.util.List;

class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> values = new ArrayList<>();
        helper(root, values);
        return buildTree(values, 0, values.size() - 1);
    }

    private TreeNode buildTree(List<Integer> values, int start, int end) {
        if (start > end) {
            return null;
        }
        if (start == end) {
            return new TreeNode(values.get(start));
        }
        int mid = (start + end) / 2;
        TreeNode root = new TreeNode(values.get(mid));
        root.left = buildTree(values, start, mid - 1);
        root.right = buildTree(values, mid + 1, end);
        return root;
    }

    private void helper(TreeNode root, List<Integer> values) {
        if (root == null) {
            return;
        }
        helper(root.left, values);
        values.add(root.val);
        helper(root.right, values);
    }
}
