import java.util.HashMap;
import java.util.Map;

class Solution2 {
    Map<Integer, Integer> valueToIndex;
    int index;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        valueToIndex = new HashMap<>();
        index = 0;
        for (int i = 0; i < inorder.length; i++) {
            valueToIndex.put(inorder[i], i);
        }

        return dfs(preorder, 0, preorder.length - 1);
    }

    private TreeNode dfs(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }
        int val = preorder[index];
        TreeNode root = new TreeNode(val);
        index++;
        root.left = dfs(preorder, start, valueToIndex.get(val) - 1);
        root.right = dfs(preorder, valueToIndex.get(val) + 1, end);
        return root;
    }
}
