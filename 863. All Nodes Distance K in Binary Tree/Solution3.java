import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution3 {
    Map<Integer, Integer> dis;
    List<Integer> res;

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        dis = new HashMap<>();
        res = new ArrayList<>();
        buildDis(root, target);
        dfs(root, k, 0);
        return res;
    }

    private void dfs(TreeNode root, int k, int cur) {
        if (root == null) {
            return;
        }
        if (dis.containsKey(root.val)) {
            cur = dis.get(root.val);
        }
        if (cur == k) {
            res.add(root.val);
        }
        dfs(root.left, k, cur + 1);
        dfs(root.right, k, cur + 1);
    }

    private int buildDis(TreeNode root, TreeNode target) {
        if (root == null) {
            return -1;
        }
        if (root == target) {
            dis.put(target.val, 0);
            return 0;
        }
        int l = buildDis(root.left, target);
        if (l != -1) {
            dis.put(root.val, l + 1);
            return l + 1;
        }
        int r = buildDis(root.right, target);
        if (r != -1) {
            dis.put(root.val, r + 1);
            return r + 1;
        }
        return -1;
    }
}
