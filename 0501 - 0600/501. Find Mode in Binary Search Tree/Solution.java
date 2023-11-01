import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list;
    int maxCount;
    int curCount;
    int prev;

    public int[] findMode(TreeNode root) {
        list = new ArrayList<>();
        maxCount = 0;
        curCount = 0;
        prev = 0;
        dfs(root);
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        int cur = root.val;
        if (cur == prev) {
            curCount++;
        } else {
            curCount = 1;
        }
        prev = cur;
        if (curCount > maxCount) {
            maxCount = curCount;
            list.clear();
            list.add(cur);
        } else if (curCount == maxCount) {
            list.add(cur);
        }
        dfs(root.right);
    }
}
