import java.util.ArrayList;
import java.util.PriorityQueue;

class Solution {


    int res;
    ArrayList<Integer>[] children;
    String str;

    public int longestPath(int[] parent, String s) {
        int n = parent.length;
        res = 0;
        str = s;
        children = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            children[i] = new ArrayList<>();
        }
        for (int i = 1; i < parent.length; i++) {
            children[parent[i]].add(i);
        }
        dfs(0);
        return res;

    }

    private int dfs(int root) {
        if (children[root].size() == 0) {
            res = Math.max(res, 1);
            return 1;
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> (b - a));
        for (Integer child : children[root]) {
            int cur = dfs(child);
            if (str.charAt(root) != str.charAt(child)) {
                pq.offer(cur);
            }
        }
        int first = pq.isEmpty() ? 0 : pq.poll();
        int second = pq.isEmpty() ? 0 : pq.poll();
        res = Math.max(res, first + second + 1);
        return first + 1;
    }
}
