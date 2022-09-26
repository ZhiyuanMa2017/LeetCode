class Solution {
    public boolean equationsPossible(String[] equations) {
        UF uf = new UF(26);
        for (String equation : equations) {
            if (equation.charAt(1) == '=') {
                int first = equation.charAt(0) - 'a';
                int second = equation.charAt(3) - 'a';
                uf.union(first, second);
            }
        }
        for (String equation : equations) {
            if (equation.charAt(1) == '!') {
                int first = equation.charAt(0) - 'a';
                int second = equation.charAt(3) - 'a';
                if (uf.find(first) == uf.find(second)) {
                    return false;
                }
            }
        }
        return true;
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
