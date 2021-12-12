import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<Integer> closestKValues(TreeNode root, double target, int k) {
        Deque<Integer> deque = new LinkedList<>();
        inorder(root, deque, target, k);
        return new ArrayList<>(deque);
    }

    private void inorder(TreeNode root, Deque<Integer> deque, double target, int k) {
        if (root == null) {
            return;
        }
        inorder(root.left, deque, target, k);
        if (deque.size() == k) {
            if (Math.abs(root.val - target) < Math.abs(deque.peekFirst() - target)) {
                deque.pollFirst();
            } else {
                return;
            }
        }
        deque.add(root.val);
        inorder(root.right, deque, target, k);
    }
}
