import java.util.HashMap;
import java.util.Map;

class Solution20211121 {
    int[] postArray;
    Map<Integer, Integer> inorderMap;
    int postIndex;

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        inorderMap = new HashMap<>();
        postArray = postorder;
        postIndex = postorder.length - 1;
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        TreeNode root = dfs(0, inorder.length - 1);
        return root;
    }

    private TreeNode dfs(int l, int r) {
        if (l > r) {
            return null;
        }
        int val = postArray[postIndex];
        postIndex--;
        int index = inorderMap.get(val);
        TreeNode root = new TreeNode(val);
        root.right = dfs(index + 1, r);
        root.left = dfs(l, index - 1);
        return root;
    }
}
