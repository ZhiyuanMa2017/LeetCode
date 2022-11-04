import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
//        List<Integer> res = new ArrayList<>();
//        if (root == null) {
//            return res;
//        }
//        res.addAll(postorderTraversal(root.left));
//        res.addAll(postorderTraversal(root.right));
//        res.add(root.val);
//        return res;
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        TreeNode pre = null;
        while (tmp != null || !s.isEmpty()) {
            if (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            } else {
                tmp = s.peek();
                if (tmp.right == null || tmp.right == pre) {
                    res.add(tmp.val);
                    s.pop();
                    pre = tmp;
                    tmp = null;
                } else {
                    tmp = tmp.right;
                }
            }
        }
        return res;
    }

    public class TreeNode {
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
