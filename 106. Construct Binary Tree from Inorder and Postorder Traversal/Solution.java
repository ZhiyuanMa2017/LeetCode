import java.util.HashMap;
import java.util.Map;

class Solution {
    int[] postOrderArray;
    Map<Integer, Integer> inorderMap;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        this.postOrderArray = postorder;
        inorderMap = new HashMap<>();
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        TreeNode root = helper(0, inorder.length - 1);
        return root;
    }

    private TreeNode helper(int left, int right) {
        if (left > right) {
            return null;
        }
        int rootVal = postOrderArray[postIndex];
        TreeNode root = new TreeNode(rootVal);
        int index = inorderMap.get(rootVal);
        postIndex--;
        root.right = helper(index + 1, right);
        root.left = helper(left, index - 1);

        return root;
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
