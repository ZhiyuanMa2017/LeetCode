class Solution {
    public boolean validateBinaryTreeNodes(int n, int[] leftChild, int[] rightChild) {
        UF uf = new UF(n);
        for (int i = 0; i < n; i++) {
            if (leftChild[i] >= 0) {
                if (uf.find(leftChild[i]) != leftChild[i] || uf.find(i) == uf.find(leftChild[i])) {
                    return false;
                }
                uf.union(i, leftChild[i]);
            }
            if (rightChild[i] >= 0) {
                if (uf.find(rightChild[i]) != rightChild[i] || uf.find(i) == uf.find(rightChild[i])) {
                    return false;
                }
                uf.union(i, rightChild[i]);
            }
        }
        return uf.count == 1;
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

        void union(int p, int child) {
            int pp = find(p);
            parent[child] = pp;
            count--;
        }
    }
}
