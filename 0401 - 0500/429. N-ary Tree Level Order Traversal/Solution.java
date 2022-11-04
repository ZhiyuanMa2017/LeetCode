import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new ArrayList<>();
        if (root == null) {
            return res;
        }
        dfs(root, res, 1);
        return res;
    }

    private void dfs(Node root, List<List<Integer>> res, int depth) {
        if (res.size() < depth) {
            res.add(new ArrayList<>());
        }
        res.get(depth - 1).add(root.val);
        for (Node child : root.children) {
            dfs(child, res, depth + 1);
        }
    }
}
