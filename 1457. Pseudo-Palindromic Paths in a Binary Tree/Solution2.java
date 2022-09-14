import java.util.Arrays;

class Solution {
    int res;

    public int pseudoPalindromicPaths(TreeNode root) {
        res = 0;
        dfs(root, new int[10]);
        return res;
    }

    private void dfs(TreeNode root, int[] count) {
        count[root.val]++;
        if (root.left == null && root.right == null) {
            if (check(count)) {
                res++;
            }
            System.out.println(Arrays.toString(count));
        } else if (root.left != null && root.right == null) {
            dfs(root.left, count);
        } else if (root.left == null) {
            dfs(root.right, count);
        } else {
            dfs(root.left, count);
            dfs(root.right, count);
        }
        count[root.val]--;
    }

    private boolean check(int[] count) {
        int odd = 0;
        for (int i = 1; i < 10; i++) {
            if (count[i] % 2 == 1) {
                odd++;
            }
            if (odd > 1) {
                return false;
            }
        }
        return true;
    }
}
