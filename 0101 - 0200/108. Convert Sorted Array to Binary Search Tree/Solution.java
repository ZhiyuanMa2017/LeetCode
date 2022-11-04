class Solution {
    public TreeNode sortedArrayToBST(int[] nums) {
        return aToB(nums, 0, nums.length - 1);
    }


    private TreeNode aToB(int[] nums, int l, int h) {
        if (l > h) {
            return null;
        }
        int m = l + (h - l) / 2;
        TreeNode tmp = new TreeNode(nums[m]);
        tmp.left = aToB(nums, l, m - 1);
        tmp.right = aToB(nums, m + 1, h);
        return tmp;
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
