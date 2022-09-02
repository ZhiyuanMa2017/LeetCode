import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Double> averageOfLevels(TreeNode root) {
        List<Double> res = new ArrayList<>();
        List<Integer> counter = new ArrayList<>();
        dfs(0, root, res, counter);
        for (int i = 0; i < res.size(); i++) {
            res.set(i, res.get(i) / counter.get(i));
        }
        return res;
    }

    private void dfs(int level, TreeNode node, List<Double> res, List<Integer> counter) {
        if (node == null) {
            return;
        }
        if (res.size() <= level) {
            res.add(0.0);
            counter.add(0);
        }
        res.set(level, res.get(level) + node.val);
        counter.set(level, counter.get(level) + 1);
        dfs(level + 1, node.left, res, counter);
        dfs(level + 1, node.right, res, counter);
    }
}
