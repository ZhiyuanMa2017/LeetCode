import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<Integer>> findCriticalAndPseudoCriticalEdges(int n, int[][] edges) {
        int[][] ee = new int[edges.length][4];
        for (int i = 0; i < edges.length; i++) {
            int a = edges[i][0];
            int b = edges[i][1];
            int weight = edges[i][2];
            ee[i][0] = a;
            ee[i][1] = b;
            ee[i][2] = weight;
            ee[i][3] = i;
        }
        Arrays.sort(ee, (a, b) -> a[2] - b[2]);
        int minWeight = calMSTWeight(n, ee, -1, new int[4], -1);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> critical = new ArrayList<>();
        List<Integer> pseudoCritical = new ArrayList<>();
        res.add(critical);
        res.add(pseudoCritical);
        for (int[] e : ee) {
            int weightWithoutE = calMSTWeight(n, ee, -1, new int[4], e[3]);
            if (weightWithoutE > minWeight) {
                critical.add(e[3]);
            } else {
                int weightWithE = calMSTWeight(n, ee, e[3], e, -1);
                if (weightWithE == minWeight) {
                    pseudoCritical.add(e[3]);
                }
            }
        }
        return res;
    }

    public int calMSTWeight(int n, int[][] ee, int useIndex, int[] use, int ignoreIndex) {
        UF uf = new UF(n);
        int res = 0;
        if (useIndex != -1) {
            int a = use[0];
            int b = use[1];
            int weight = use[2];
            uf.union(a, b);
            res += weight;
        }
        for (int[] e : ee) {
            int a = e[0];
            int b = e[1];
            int weight = e[2];
            int index = e[3];
            if (index == ignoreIndex) {
                continue;
            }
            if (uf.find(a) != uf.find(b)) {
                uf.union(a, b);
                res += weight;
            }
        }
        if (uf.count != 1) {
            return Integer.MAX_VALUE;
        } else {
            return res;
        }
    }

    class UF {
        int[] parent;
        int[] size;
        int count;


        UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = i;
            }
        }

        public int find(int i) {
            while (i != parent[i]) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        public void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            } else if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
                count--;
            } else {
                parent[p] = q;
                size[q] += size[p];
                count--;
            }
        }
    }
}
