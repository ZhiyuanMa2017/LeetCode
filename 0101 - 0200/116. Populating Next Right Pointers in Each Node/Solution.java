class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return null;
        }
        Node pre = root;

        while (pre.left != null) {
            Node cur = pre;
            while (cur != null) {
                cur.left.next = cur.right;
                if (cur.next != null) {
                    cur.right.next = cur.next.left;
                }
                cur = cur.next;
            }
            pre = pre.left;
        }
        return root;
    }
    /**
     * 1. Go through every layer using the NEXT pointer to this layer's last node
     * 2. For every node, point left child's NEXT to the right child
     * 3. Check if this node had a NEXT node,
     *    if have, point right child's NEXT to the this node's NEXT node's left child.
     * 4. Repeat until the second to last layer
     * 5. Nodes in the last layer have no children, so it will not enter the WHILE
     */
}

