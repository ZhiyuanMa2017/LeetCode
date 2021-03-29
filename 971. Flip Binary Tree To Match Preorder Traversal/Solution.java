import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    List<Integer> res = new ArrayList<>();
    int i = 0;

    public List<Integer> flipMatchVoyage(TreeNode root, int[] voyage) {
        if (dfs(root, voyage)) {
            return res;
        } else {
            return Collections.singletonList(-1);
        }
    }

    private boolean dfs(TreeNode node, int[] v) {
        if (node == null) {
            return true;
        }
        if (node.val != v[i++]) {
            return false;
        }

        // this node's tree need flip
        if (node.left != null && node.left.val != v[i]) {
            res.add(node.val);
            return dfs(node.right, v) && dfs(node.left, v);
            // flipped, so right is now on the left side
        }

        // does not need flip
        return dfs(node.left, v) && dfs(node.right, v);
    }
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
