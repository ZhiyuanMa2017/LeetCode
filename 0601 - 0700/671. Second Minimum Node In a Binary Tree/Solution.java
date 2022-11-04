class Solution {
    int min;
    long res;

    public int findSecondMinimumValue(TreeNode root) {
        if (root.left == null) {
            return -1;
        }
        min = root.val;
        res = Long.MAX_VALUE;
        dfs(root);
        if (res == Long.MAX_VALUE) {
            return -1;
        }
        return (int) res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        if (min < root.val && root.val < res) {
            res = root.val;
        } else if (root.val == min) {
            dfs(root.left);
            dfs(root.right);
        }
    }
}
