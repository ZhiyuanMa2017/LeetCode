import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> s = new Stack<>();
        TreeNode tmp = root;
        while (tmp != null || !s.isEmpty()) {
            while (tmp != null) {
                s.push(tmp);
                tmp = tmp.left;
            }
            tmp = s.pop();
            res.add(tmp.val);
            tmp = tmp.right;
        }
        return res;
//        List<Integer> res = new ArrayList<>();
//        helper(root, res);
//        return res;
    }

    private void helper(TreeNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        helper(node.left, list);
        list.add(node.val);
        helper(node.right, list);
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
