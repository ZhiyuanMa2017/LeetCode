import java.util.HashMap;

class Solution {
    Map<Node, NodeCopy> map;

    public NodeCopy copyRandomBinaryTree(Node root) {
        map = new HashMap<>();
        NodeCopy rootCopy = dfs1(root);
        dfs2(root);
        return rootCopy;
    }

    private NodeCopy dfs1(Node root) {
        if (root == null) {
            return null;
        }
        NodeCopy rootCopy = new NodeCopy(root.val);
        rootCopy.left = dfs1(root.left);
        rootCopy.right = dfs1(root.right);
        map.put(root, rootCopy);
        return rootCopy;
    }

    private void dfs2(Node root) {
        if (root == null) {
            return;
        }
        NodeCopy rootCopy = map.get(root);
        rootCopy.random = map.get(root.random);
        dfs2(root.left);
        dfs2(root.right);
    }
}
