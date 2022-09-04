import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colToRowToVals = new TreeMap<>();
        dfs(root, 0, 0, colToRowToVals);
        List<List<Integer>> res = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> rowToVals : colToRowToVals.values()) {
            res.add(new ArrayList<>());
            for (PriorityQueue<Integer> values : rowToVals.values()) {
                while (!values.isEmpty()) {
                    res.get(res.size() - 1).add(values.poll());
                }
            }
        }
        return res;
    }

    private void dfs(TreeNode root, int col, int layer, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> colToRowToVals) {
        if (root == null) {
            return;
        }
        if (!colToRowToVals.containsKey(col)) {
            colToRowToVals.put(col, new TreeMap<>());
        }
        if (!colToRowToVals.get(col).containsKey(layer)) {
            colToRowToVals.get(col).put(layer, new PriorityQueue<>());
        }
        colToRowToVals.get(col).get(layer).add(root.val);
        dfs(root.left, col - 1, layer + 1, colToRowToVals);
        dfs(root.right, col + 1, layer + 1, colToRowToVals);
    }
}
