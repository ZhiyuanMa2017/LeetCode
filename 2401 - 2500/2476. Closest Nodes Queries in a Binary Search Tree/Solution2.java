import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;


class Solution {
    TreeSet<Integer> treeSet;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        treeSet = new TreeSet<>();
        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            Integer prev = treeSet.floor(query);
            Integer next = treeSet.ceiling(query);
            List<Integer> cur = List.of(prev == null ? -1 : prev, next == null ? -1 : next);
            res.add(cur);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        treeSet.add(root.val);
        dfs(root.right);
    }
}
