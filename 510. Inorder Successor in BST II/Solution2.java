class Solution {
    public Node inorderSuccessor(Node node) {
        if (node.right == null) {
            Node res = node;
            while (res.parent != null && res.parent.right == res) {
                res = res.parent;
            }
            return res.parent;
        } else {
            Node res = node.right;
            while (res.left != null) {
                res = res.left;
            }
            return res;
        }
    }
}
