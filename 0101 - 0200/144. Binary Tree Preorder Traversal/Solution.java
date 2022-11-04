import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> preorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        res.add(root.val);
//        res.addAll(preorderTraversal(root.left));
//        res.addAll(preorderTraversal(root.right));
//        return res;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !s.isEmpty()) {
            while (tmp != null) {
                res.add(tmp.val);
                s.push(tmp);
                tmp = tmp.left;
            }
            tmp = s.pop().right;
        }
        return res;
    }

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
