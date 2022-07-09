class Solution {
    Node res;
    Node prev;

    public Node inorderSuccessor(Node node) {
        Node cur = node;
        while (cur.parent != null) {
            cur = cur.parent;
        }
        dfs(cur, node);
        return res;
    }

    private void dfs(Node root, Node node) {
        if (root == null) {
            return;
        }
        dfs(root.left, node);
        if (prev == node) {
            res = root;
        }
        prev = root;
        dfs(root.right, node);
    }

    class Node {
        public int val;
        public Node left;
        public Node right;
        public Node parent;
    }
}
