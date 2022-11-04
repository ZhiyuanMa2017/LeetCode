import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> getAllElements(TreeNode root1, TreeNode root2) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        dfs(root1, l1);
        dfs(root2, l2);
        int i = 0;
        int j = 0;
        List<Integer> res = new ArrayList<>();
        while (i < l1.size() && j < l2.size()) {
            if (l1.get(i) <= l2.get(j)) {
                res.add(l1.get(i));
                i++;
            } else {
                res.add(l2.get(j));
                j++;
            }
        }
        while (i < l1.size()) {
            res.add(l1.get(i));
            i++;
        }
        while (j < l2.size()) {
            res.add(l2.get(j));
            j++;
        }
        return res;
    }

    private void dfs(TreeNode node, List<Integer> l) {
        if (node == null) {
            return;
        }
        dfs(node.left, l);
        l.add(node.val);
        dfs(node.right, l);
    }
}
