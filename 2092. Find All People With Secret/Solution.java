import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
        TreeMap<Integer, List<int[]>> map = new TreeMap<>();
        UF uf = new UF(n);
        uf.union(0, firstPerson);
        for (int[] meeting : meetings) {
            int p1 = meeting[0];
            int p2 = meeting[1];
            int time = meeting[2];
            if (map.containsKey(time)) {
                map.get(time).add(new int[]{p1, p2});
            } else {
                map.put(time, new ArrayList<>());
                map.get(time).add(new int[]{p1, p2});
            }
        }
        for (Integer i : map.keySet()) {
            Set<Integer> set = new HashSet<>();
            for (int[] ints : map.get(i)) {
                int p1 = ints[0];
                int p2 = ints[1];
                uf.union(p1, p2);
                set.add(p1);
                set.add(p2);
            }
            for (Integer j : set) {
                if (uf.find(j) != uf.find(0)) {
                    uf.reset(j);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (uf.find(i) == uf.find(0)) {
                res.add(i);
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

        public void reset(int i) {
            parent[i] = i;
            size[i] = 1;
        }
    }
}
