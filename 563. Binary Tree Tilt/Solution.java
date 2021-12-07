class Solution {
    public int findTilt(TreeNode root) {
        return findhelper(root)[0];
    }

    private int[] findhelper(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        } else {
            // first element store tile, seconed element store sum
            int[] leftresult = findhelper(root.left);
            int[] rightresult = findhelper(root.right);

            int tilt = leftresult[0] + rightresult[0] + Math.abs(leftresult[1] - rightresult[1]);
            int sum = leftresult[1] + rightresult[1] + root.val;

            return new int[]{tilt, sum};
        }
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
