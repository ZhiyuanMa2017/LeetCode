class Solution {
    enum M { Camera, Monitored, NotMonitored }

    public int minCameraCover(TreeNode root) {
        Status s = getStatus(root);
        if (s.m == M.NotMonitored) {
            s.countFromLeaf++;
        }
        return s.countFromLeaf;
    }

    private Status getStatus(TreeNode node) {
        if (node == null) {
            return new Status(0, M.Monitored);
        }

        Status l = getStatus(node.left);
        Status r = getStatus(node.right);

        Status curr = new Status(l.countFromLeaf + r.countFromLeaf, M.NotMonitored);
        if (l.m == M.NotMonitored || r.m == M.NotMonitored) {
            curr.countFromLeaf++;
            curr.m = M.Camera;
        } else if (l.m == M.Camera || r.m == M.Camera) {
            curr.m = M.Monitored;
        }
        return curr;
    }


    private class Status {
        int countFromLeaf;
        M m;

        Status(int countFromLeaf, M m) {
            this.countFromLeaf = countFromLeaf;
            this.m = m;
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
