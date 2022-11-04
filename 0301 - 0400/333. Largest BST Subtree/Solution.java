class Solution {
    int res;

    public int largestBSTSubtree(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 10001, -10001};
        }
        // count, min, max
        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        if (l[0] == -1 || r[0] == -1) {
            return new int[]{-1, -10001, 10001};
        }
        if (root.val <= l[2] || root.val >= r[1]) {
            return new int[]{-1, -10001, 10001};
        }
        res = Math.max(res, 1 + l[0] + r[0]);
        return new int[]{1 + l[0] + r[0], Math.min(l[1], root.val), Math.max(r[2], root.val)};
    }
}
