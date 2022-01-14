class Solution2 {
    public Node lowestCommonAncestor(Node p, Node q) {
        Node a = p;
        Node b = q;
        while (a != b) {
            a = a == null ? q : a.parent;
            b = b == null ? p : b.parent;
        }
        return a;
    }
}
