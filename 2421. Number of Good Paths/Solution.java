import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

class Solution {
    public int numberOfGoodPaths(int[] vals, int[][] edges) {
        int n = vals.length;
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        TreeMap<Integer, List<Integer>> valToPoints = new TreeMap<>();
        for (int i = 0; i < vals.length; i++) {
            int val = vals[i];
            if (!valToPoints.containsKey(val)) {
                valToPoints.put(val, new ArrayList<>());
            }
            valToPoints.get(val).add(i);
        }
        UF uf = new UF(n);
        int res = 0;
        boolean[] used = new boolean[n];
        for (Integer val : valToPoints.keySet()) {
            List<Integer> list = valToPoints.get(val);
            for (Integer point : list) {
                used[point] = true;
                for (Integer next : graph.get(point)) {
                    if (used[next]) {
                        uf.union(point, next);
                    }
                }
            }
            Map<Integer, Integer> count = new HashMap<>();
            for (Integer integer : list) {
                int p = uf.find(integer);
                count.put(p, count.getOrDefault(p, 0) + 1);
            }
            for (Integer value : count.values()) {
                res += value * (value + 1) / 2;
            }
        }

        return res;
    }

    class UF {
        int[] parent;
        int[] size;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (q == p) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
