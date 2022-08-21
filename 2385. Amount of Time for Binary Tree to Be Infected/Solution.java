class Solution {
    int res;

    public int amountOfTime(TreeNode root, int start) {
        res = 0;
        dfs(root, start);
        return res;
    }


    private int[] dfs(TreeNode root, int start) {
        // int[]{distance to leaf, distance to start}
        int[] cur = new int[]{0, -1};
        if (root == null) {
            return cur;
        }
        int[] l = dfs(root.left, start);
        int[] r = dfs(root.right, start);
        cur[0] = Math.max(l[0], r[0]) + 1;
        if (root.val == start) {
            cur[1] = 0;
            res = Math.max(res, cur[0] - 1);
        }
        if (l[1] > -1) {
            cur[1] = l[1] + 1;
            res = Math.max(res, r[0] + cur[1]);
        }
        if (r[1] > -1) {
            cur[1] = r[1] + 1;
            res = Math.max(res, l[0] + cur[1]);
        }
        return cur;
    }
}
