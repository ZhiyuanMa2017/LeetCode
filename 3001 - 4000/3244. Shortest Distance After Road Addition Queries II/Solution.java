import java.util.TreeSet;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (int i = 0; i < n; i++) {
            treeSet.add(i);
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            Integer higher = treeSet.higher(l);
            while (higher != null && higher < r) {
                treeSet.remove(higher);
                higher = treeSet.higher(higher);
            }
            res[i] = treeSet.size() - 1;
        }
        return res;
    }
}
