class Solution {
    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        UF uf = new UF(26);
        for (int i = 0; i < s1.length(); i++) {
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(i);
            uf.union(c1 - 'a', c2 - 'a');
        }
        StringBuilder sb = new StringBuilder();
        for (char c : baseStr.toCharArray()) {
            int p = uf.find(c - 'a');
            sb.append((char) ('a' + p));
        }
        return sb.toString();
    }

    class UF {
        int[] parent;

        UF(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
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
            if (p < q) {
                parent[q] = p;
            } else {
                parent[p] = q;
            }
        }
    }
}
