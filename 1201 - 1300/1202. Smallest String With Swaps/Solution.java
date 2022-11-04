import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        int n = s.length();
        UF uf = new UF(n);
        for (List<Integer> pair : pairs) {
            int first = pair.get(0);
            int second = pair.get(1);
            uf.union(first, second);
        }
        Map<Integer, PriorityQueue<Character>> rootToChar = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            if (!rootToChar.containsKey(root)) {
                rootToChar.put(root, new PriorityQueue<>());
            }
            rootToChar.get(root).offer(s.charAt(i));
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            int root = uf.find(i);
            sb.append(rootToChar.get(root).poll());
        }
        return sb.toString();
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
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }

        void union(int i, int j) {
            int p = find(i);
            int q = find(j);
            if (p == q) {
                return;
            } else if (size[p] > size[q]) {
                parent[q] = p;
                size[p] += size[q];
            } else {
                parent[p] = q;
                size[q] += size[p];
            }
        }
    }
}
