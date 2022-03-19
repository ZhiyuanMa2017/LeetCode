class Solution {
    Node head;
    Node tail;
    Node pre;

    public Node treeToDoublyList(Node root) {
        if (root == null) {
            return head;
        }
        head = null;
        tail = null;
        pre = null;
        dfs(root);
        head.left = tail;
        tail.right = head;
        return head;
    }

    private void dfs(Node root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        if (pre == null) {
            pre = root;
        } else {
            pre.right = root;
            root.left = pre;
            pre = root;
        }
        if (head == null) {
            head = root;
        }
        tail = root;
        dfs(root.right);
    }
}
