import java.util.HashMap;
import java.util.Map;

class Solution {
    Map<TreeNode, Integer> nodeToHeight;
    int[] res;

    public int[] treeQueries(TreeNode root, int[] queries) {
        nodeToHeight = new HashMap<>();
        dfs(root);
        nodeToHeight.put(null, 0);
        res = new int[nodeToHeight.size()];
        dfs2(root, 0, 0);
        int[] queryResult = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            queryResult[i] = res[queries[i]] - 1;
        }
        return queryResult;
    }

    private void dfs2(TreeNode root, int depth, int restHeight) {
        if (root == null) {
            return;
        }
        depth++;
        res[root.val] = restHeight;
        dfs2(root.left, depth, Math.max(restHeight, depth + nodeToHeight.get(root.right)));
        dfs2(root.right, depth, Math.max(restHeight, depth + nodeToHeight.get(root.left)));
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int l = dfs(root.left);
        int r = dfs(root.right);
        int h = Math.max(l, r) + 1;
        nodeToHeight.put(root, h);
        return h;
    }
}
