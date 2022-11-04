class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parents = new int[edges.length + 1];
        for (int[] edge : edges) {
            int firstP = find(parents, edge[0]);
            int secondP = find(parents, edge[1]);
            if (firstP == secondP) {
                return edge;
            }
            parents[secondP] = firstP;
        }
        return new int[]{};
    }

    private int find(int[] parents, int v) {
        return parents[v] == 0 ? v : find(parents, parents[v]);
    }
}
