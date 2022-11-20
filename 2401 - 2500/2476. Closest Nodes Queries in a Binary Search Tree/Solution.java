import java.util.ArrayList;
import java.util.List;

class Solution {
    List<Integer> list;

    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        list = new ArrayList<>();
        dfs(root);
        List<List<Integer>> res = new ArrayList<>();
        for (Integer query : queries) {
            List<Integer> cur = List.of(findLast(query), findFirst(query));
            res.add(cur);
        }
        return res;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        list.add(root.val);
        dfs(root.right);
    }

    private int findLast(int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + (r - l + 1) / 2;
            if (list.get(mid) > target) {
                r = mid - 1;
            } else {
                l = mid;
            }
        }
        return list.get(l) <= target ? list.get(l) : -1;
    }

    private int findFirst(int target) {
        int l = 0;
        int r = list.size() - 1;
        while (l < r) {
            int mid = l + (r - l) / 2;
            if (list.get(mid) < target) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        return list.get(l) >= target ? list.get(l) : -1;
    }
}
