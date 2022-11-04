import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

class Solution2 {
    PriorityQueue<int[]> pq;

    public List<List<Integer>> verticalTraversal(TreeNode root) {
        pq = new PriorityQueue<>(
                new Comparator<int[]>() {
                    @Override
                    public int compare(int[] a, int[] b) {
                        if (a[1] != b[1]) {
                            return Integer.compare(a[1], b[1]);
                        }
                        if (a[0] != b[0]) {
                            return Integer.compare(a[0], b[0]);
                        }
                        return a[2] - b[2];
                    }
                }
        );
        dfs(root, 0, 0);
        List<List<Integer>> res = new ArrayList<>();
        int prev = -1000;
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int r = cur[0];
            int c = cur[1];
            int val = cur[2];
            if (c != prev) {
                res.add(new ArrayList<>());
                prev = c;
            }
            res.get(res.size() - 1).add(val);
        }
        return res;
    }

    private void dfs(TreeNode root, int r, int c) {
        if (root == null) {
            return;
        }
        pq.offer(new int[]{r, c, root.val});
        dfs(root.left, r + 1, c - 1);
        dfs(root.right, r + 1, c + 1);
    }
}
