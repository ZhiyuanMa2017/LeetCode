import java.util.HashSet;
import java.util.Set;

class Solution {
    public int removeStones(int[][] stones) {
        UF uf = new UF(20002);
        int n = stones.length;
        for (int[] stone : stones) {
            uf.union(stone[0], stone[1] + 10001);
        }
        Set<Integer> father = new HashSet<>();
        for (int[] stone : stones) {
            father.add(uf.find(stone[0]));
        }
        return n - father.size();
    }

    class UF {

        int[] size;
        int[] parent;

        UF(int n) {
            size = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                size[i] = 1;
                parent[i] = i;
            }
        }

        int find(int i) {
            while (parent[i] != i) {
                i = parent[parent[i]];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            }
            if (size[p] > size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
