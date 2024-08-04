import java.util.TreeMap;

class Solution {
    public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
        TreeMap<Integer, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < n - 1; i++) {
            treeMap.put(i, i + 1);
        }
        int m = queries.length;
        int[] res = new int[m];
        for (int i = 0; i < m; i++) {
            int l = queries[i][0];
            int r = queries[i][1];
            Integer floor = treeMap.floorKey(l);
            if (treeMap.get(floor) >= r) {
                res[i] = treeMap.size();
            } else {
                Integer ceiling = treeMap.ceilingKey(l);
                while (ceiling != null && treeMap.get(ceiling) <= r) {
                    treeMap.remove(ceiling);
                    ceiling = treeMap.ceilingKey(ceiling);
                }
                treeMap.put(l, r);
                res[i] = treeMap.size();
            }
        }
        return res;
    }
}
