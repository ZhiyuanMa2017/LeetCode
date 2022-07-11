import java.util.List;
import java.util.ArrayList;

class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        helper(root, res, 0);
        return res;
    }

    private void helper(TreeNode node, List<Integer> res, int layer) {
        if (node == null) {
            return;
        }
        if (layer == res.size()) {
            res.add(node.val);
        }
        helper(node.right, res, layer + 1);
        helper(node.left, res, layer + 1);
    }
}
