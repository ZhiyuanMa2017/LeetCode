class Solution {
    int res;

    // true => left dir
    // false => right dir
    public int longestZigZag(TreeNode root) {
        res = 0;
        dfs(root.left, 1, true);
        dfs(root.right, 1, false);
        return res;
    }

    private void dfs(TreeNode root, int length, boolean dir) {
        if (root == null) {
            res = Math.max(res, length - 1);
            return;
        }
        if (dir) {
            dfs(root.left, 1, true);
            dfs(root.right, length + 1, false);
        } else {
            dfs(root.left, length + 1, true);
            dfs(root.right, 1, false);
        }
    }
}
