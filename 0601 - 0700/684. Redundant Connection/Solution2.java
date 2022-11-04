class Solution2 {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        for (int i = 1; i < n; i++) {
            parent[i] = i;
        }
        for (int[] edge : edges) {
            int i = edge[0];
            int j = edge[1];
            int p = find(i, parent);
            int q = find(j, parent);
            if (p == q) {
                return edge;
            }
            parent[q] = p;
        }
        return new int[]{};
    }

    private int find(int i, int[] parent) {
        while (i != parent[i]) {
            parent[i] = parent[parent[i]];
            i = parent[i];
        }
        return i;
    }
}
