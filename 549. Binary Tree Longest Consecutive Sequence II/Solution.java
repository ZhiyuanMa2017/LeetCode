class Solution {
    int res;

    public int longestConsecutive(TreeNode root) {
        res = 0;
        dfs(root);
        return res;
    }

    private int[] dfs(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        int[] cur = new int[]{1, 1};
        if (root.left != null) {
            int[] l = dfs(root.left);
            if (root.val == root.left.val + 1) {
                cur[0] = l[0] + 1;
            } else if (root.val == root.left.val - 1) {
                cur[1] = l[1] + 1;
            }
        }
        if (root.right != null) {
            int[] r = dfs(root.right);
            if (root.val == root.right.val + 1) {
                cur[0] = Math.max(cur[0], r[0] + 1);
            } else if (root.val == root.right.val - 1) {
                cur[1] = Math.max(cur[1], r[1] + 1);
            }
        }
        res = Math.max(res, cur[0] + cur[1] - 1);
        return cur;
    }
}
