class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node sentinel = new Node(0);
        Node cur = root;
        while (cur != null) {
            Node pre = sentinel;
            while (cur != null) {
                if (cur.left != null) {
                    pre.next = cur.left;
                    pre = pre.next;
                }
                if (cur.right != null) {
                    pre.next = cur.right;
                    pre = pre.next;
                }
                cur = cur.next;
            }
            cur = sentinel.next;
            sentinel.next = null;
        }
        return root;
    }
}
