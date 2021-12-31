class Solution2 {
    int res = 0;

    public int maxAncestorDiff(TreeNode root) {
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return null;
        }
        int[] left = dfs(root.left);
        int[] right = dfs(root.right);
        int curMin = root.val;
        int curMax = root.val;
        if (left != null) {
            res = Math.max(res, Math.max(Math.abs(root.val - left[0]), Math.abs(root.val - left[1])));
            curMin = Math.min(curMin, left[0]);
            curMax = Math.max(curMax, left[1]);
        }
        if (right != null) {
            res = Math.max(res, Math.max(Math.abs(root.val - right[0]), Math.abs(root.val - right[1])));
            curMin = Math.min(curMin, right[0]);
            curMax = Math.max(curMax, right[1]);
        }
        return new int[]{curMin, curMax};

    }
}
