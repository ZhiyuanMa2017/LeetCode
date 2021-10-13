import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Solution {
    static class UF {
        int[] parent;
        int[] size;
        int count;

        UF(int n) {
            parent = new int[n];
            size = new int[n];
            count = n;
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
            if (p == q) {
                return;
            }
            if (size[p] >= size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
            count--;
        }
    }

    public static int countGroups(List<String> related) {
        int n = related.size();
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (related.get(i).charAt(j) == '1') {
                    uf.union(i, j);
                }
            }
        }
        return uf.count;
    }

    public static void main(String[] args) {
        List<String> related = Stream.of("1100", "0100", "1010", "0001").collect(Collectors.toList());
        System.out.println(countGroups(related));
    }
}
