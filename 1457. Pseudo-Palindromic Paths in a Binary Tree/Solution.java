import java.util.HashSet;

class Solution {
    public int pseudoPalindromicPaths(TreeNode root) {
        return helper(root, new HashSet<Integer>());
    }

    private int helper(TreeNode root, HashSet set) {
        if (root == null) {
            return 0;
        }
        if (set.contains(root.val)) {
            set.remove(root.val);
        } else {
            set.add(root.val);
        }
        if (root.left == null && root.right == null) {
            if (set.size() <= 1) {
                return 1;
            } else {
                return 0;
            }
        }
        int l = helper(root.left, new HashSet(set));
        int r = helper(root.right, new HashSet(set));
        return l + r;
    }
}
