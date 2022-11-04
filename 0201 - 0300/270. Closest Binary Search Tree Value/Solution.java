class Solution {
    public int closestValue(TreeNode root, double target) {
        int res = root.val;
        int val = root.val;
        while (root != null) {
            val = root.val;
            if (Math.abs(val - target) < Math.abs(res - target)) {
                res = val;
            }
            if (val < target) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return res;
    }
}
