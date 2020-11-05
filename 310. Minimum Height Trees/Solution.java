import java.util.*;

/**
 * https://leetcode.com/problems/minimum-height-trees/discuss/76055/Share-some-thoughts
 */
class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            List<Integer> res = new ArrayList<>(Arrays.asList(0));
            return res;
        } else {
            Map<Integer, Set<Integer>> graph = new HashMap<>();
            for (int i = 0; i < n; i++) {
                graph.put(i, new HashSet<>());
            }
            // build a map to store nodes and their edges
            for (int[] edge : edges) {
                graph.get(edge[0]).add(edge[1]);
                graph.get(edge[1]).add(edge[0]);
            }
            // find the node and store its connected node as the symbol of edge
            // if only add one connected node to set, this node is a leaf
            // then store those leaves
            List<Integer> leaves = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                if (graph.get(i).size() == 1) {
                    leaves.add(i);
                }
            }
            while (n > 2) {
                List<Integer> newleaves = new ArrayList<>();
                n = n - leaves.size();
                // set n to number of nodes which are not leaves
                for (Integer leaf : leaves) {
                    int parent = graph.get(leaf).iterator().next();
                    // get leaves' connected node
                    graph.get(parent).remove(leaf);
                    // go to the parent's set and delete parent's this leaf
                    // then check new leaf
                    if (graph.get(parent).size() == 1) {
                        newleaves.add(parent);
                    }
                }
                // set new leaf list
                leaves = newleaves;
            }
            return leaves;
        }
    }
}
