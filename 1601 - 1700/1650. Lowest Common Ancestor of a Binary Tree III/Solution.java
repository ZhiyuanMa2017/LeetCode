import java.util.HashSet;
import java.util.Set;

class Solution {
    public Node lowestCommonAncestor(Node p, Node q) {
        Set<Integer> s = new HashSet<>();
        Node cur = p;
        while (cur != null) {
            s.add(cur.val);
            if (cur.parent == null) {
                break;
            }
            cur = cur.parent;
        }
        cur = q;
        while (cur != null) {
            if (s.contains(cur.val)) {
                return cur;
            }
            if (cur.parent == null) {
                break;
            }
            cur = cur.parent;
        }
        return null;
    }
}
