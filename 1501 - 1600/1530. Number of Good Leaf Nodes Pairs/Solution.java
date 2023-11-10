class Solution {
    int res;

    public int countPairs(TreeNode root, int distance) {
        res = 0;
        dfs(root, distance);
        return res;
    }

    private int[] dfs(TreeNode root, int distance) {
        int[] count = new int[11];
        if (root == null) {
            return count;
        }
        if (root.left == null && root.right == null) {
            count[1] = 1;
            return count;
        }
        int[] l = dfs(root.left, distance);
        int[] r = dfs(root.right, distance);
        for (int i = 1; i <= 10; i++) {
            for (int j = 1; j <= 10; j++) {
                if (i + j <= distance) {
                    res += l[i] * r[j];
                }
            }
        }
        for (int i = 1; i < 10; i++) {
            count[i] = l[i - 1] + r[i - 1];
        }
        return count;
    }
}
