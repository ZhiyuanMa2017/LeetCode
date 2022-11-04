class Solution2 {
    public int minCameraCover(TreeNode root) {
        int[] n = dfs(root);
        int count = n[0];
        if (n[1] == -1) {
            count++;
        }
        return count;
    }

    // 1 camera
    // 0 monitored
    // -1 not monitored
    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }

        int[] l = dfs(root.left);
        int[] r = dfs(root.right);
        int count = l[0] + r[0];
        int status = -1;
        if (l[1] == -1 || r[1] == -1) {
            count++;
            status = 1;
        } else if (l[1] == 1 || r[1] == 1) {
            status = 0;
        }
        return new int[]{count, status};
    }
}
