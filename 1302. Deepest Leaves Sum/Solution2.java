class Solution2 {
    int res;
    int d;

    public int deepestLeavesSum(TreeNode root) {
        res = root.val;
        d = 1;
        dfs(root, 1);
        return res;
    }

    private void dfs(TreeNode root, int depth) {
        if (root == null) {
            return;
        }
        int curDepth = depth + 1;
        if (curDepth > d) {
            d = curDepth;
            res = root.val;
        } else if (curDepth == d) {
            res += root.val;
        }
        dfs(root.left, curDepth);
        dfs(root.right, curDepth);
    }
}
