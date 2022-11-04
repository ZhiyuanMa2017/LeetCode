import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution2 {
    List<List<Integer>> res;

    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        res = new ArrayList<>();
        dfs(root, 1);
        for (int i = 0; i < res.size(); i++) {
            if (i % 2 != 0) {
                Collections.reverse(res.get(i));
            }

        }
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth - 1).add(root.val);
        dfs(root.left, depth + 1);
        dfs(root.right, depth + 1);
    }
}
