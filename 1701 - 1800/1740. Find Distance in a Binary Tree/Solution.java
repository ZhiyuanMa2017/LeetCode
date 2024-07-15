class Solution {
    public int findDistance(TreeNode root, int p, int q) {
        TreeNode lca = findLCA(root, p, q);
        System.out.println(lca.val);
        int pD = getDistance(lca, p);
        int qD = getDistance(lca, q);
        System.out.println(pD);
        System.out.println(qD);
        return pD + qD;
    }

    private TreeNode findLCA(TreeNode root, int p, int q) {
        if (root == null) {
            return null;
        }
        if (root.val == p || root.val == q) {
            return root;
        }
        TreeNode l = findLCA(root.left, p, q);
        TreeNode r = findLCA(root.right, p, q);
        if (l == null && r == null) {
            return null;
        } else if (l != null && r != null) {
            return root;
        } else if (l != null) {
            return l;
        } else {
            return r;
        }
    }

    private int getDistance(TreeNode root, int val) {
        if (root == null) {
            return -1;
        }
        if (root.val == val) {
            return 0;
        }
        int l = getDistance(root.left, val);
        int r = getDistance(root.right, val);
        if (l == -1 && r == -1) {
            return -1;
        } else if (l != -1) {
            return l + 1;
        } else {
            return r + 1;
        }
    }
}
