import java.util.ArrayList;
import java.util.List;


class Solution {
    private List<List<Integer>> res;

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        backtrack(root, new ArrayList<>(), targetSum);
        return res;
    }

    private void backtrack(TreeNode root, List<Integer> path, int target) {
        path.add(root.val);
        if (root.left == null && root.right == null) {
            if (target == root.val) {
                res.add(new ArrayList<>(path));
            }
        }
        if (root.left != null) {
            backtrack(root.left, path, target - root.val);
        }
        if (root.right != null) {
            backtrack(root.right, path, target - root.val);
        }
        path.remove(path.size() - 1);
    }
}
