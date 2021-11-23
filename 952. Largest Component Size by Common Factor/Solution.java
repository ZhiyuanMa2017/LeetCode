import java.util.HashMap;
import java.util.Map;

class Solution {
    public int largestComponentSize(int[] nums) {
        int n = nums.length;
        UF uf = new UF(n);
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (map.containsKey(num)) {
                uf.union(i, map.get(num));
            } else {
                map.put(num, i);
            }
            for (int j = 2; j * j <= num; j++) {
                if (num % j == 0) {
                    if (map.containsKey(j)) {
                        uf.union(i, map.get(j));
                    } else {
                        map.put(j, i);
                    }
                    if (map.containsKey(num / j)) {
                        uf.union(i, map.get(num / j));
                    } else {
                        map.put(num / j, i);
                    }
                }

            }
        }
        return uf.max;
    }

    class UF {
        int[] parent;
        int[] size;
        int max;

        public UF(int n) {
            parent = new int[n];
            size = new int[n];
            max = 1;
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        private int find(int i) {
            while (parent[i] != i) {
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        private void union(int i, int j) {
            int pi = find(i);
            int pj = find(j);
            if (pi == pj) {
                return;
            }
            if (pi > pj) {
                parent[pj] = pi;
                size[pi] += size[pj];
                max = Math.max(max, size[pi]);
            } else {
                parent[pi] = pj;
                size[pj] += size[pi];
                max = Math.max(max, size[pj]);
            }
        }
    }
}
