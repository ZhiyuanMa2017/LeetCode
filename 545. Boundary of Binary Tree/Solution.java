import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<Integer> boundaryOfBinaryTree(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        if (!isLeaf(root)) {
            res.add(root.val);
        }
        TreeNode node = root.left;
        while (node != null) {
            if (!isLeaf(node)) {
                res.add(node.val);
            }
            if (node.left != null) {
                node = node.left;
            } else {
                node = node.right;
            }
        }

        addLeaves(root, res);
        node = root.right;
        Deque<Integer> stack = new ArrayDeque<>();
        while (node != null) {
            if (!isLeaf(node)) {
                stack.push(node.val);
            }
            if (node.right != null) {
                node = node.right;
            } else {
                node = node.left;
            }
        }
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        return res;
    }

    private void addLeaves(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        if (isLeaf(root)) {
            res.add(root.val);
        } else {
            addLeaves(root.left, res);
            addLeaves(root.right, res);
        }
    }

    private boolean isLeaf(TreeNode node) {
        return node.left == null && node.right == null;
    }
}
