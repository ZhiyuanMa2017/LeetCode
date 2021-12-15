class Solution {
    int res;

    public int longestConsecutive(TreeNode root) {
        res = 0;
        dfs(root, Integer.MAX_VALUE, 0);
        return res;
    }

    private void dfs(TreeNode root, int val, int count) {
        if (root == null) {
            return;
        }
        if (root.val == val + 1) {
            count += 1;
        } else {
            count = 1;
        }
        res = Math.max(res, count);
        dfs(root.left, root.val, count);
        dfs(root.right, root.val, count);
    }

    public static void main(String[] args) {
        TreeNode root = new Codec().deserialize("1,null,3,2,4,null,null,null,5");
        Solution s = new Solution();
        s.longestConsecutive(root);
    }
}
