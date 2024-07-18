import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> res = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        for (int i : to_delete) {
            set.add(i);
        }
        dfs(root, set, false, res);
        return res;
    }

    private void dfs(TreeNode root, Set<Integer> set, boolean added, List<TreeNode> res) {
        if (root == null) {
            return;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        if (root.left != null && set.contains(root.left.val)) {
            root.left = null;
        }
        if (root.right != null && set.contains(root.right.val)) {
            root.right = null;
        }
        if (set.contains(root.val)) {
            dfs(left, set, false, res);
            dfs(right, set, false, res);
        } else {
            if (!added) {
                res.add(root);
            }
            dfs(left, set, true, res);
            dfs(right, set, true, res);
        }
    }
}
