import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        Set<Integer> q = new HashSet<>();
        q.add(1);
        int total = 0;
        int[] count = new int[n + 1];
        long first = 0;
        while (true) {
            if ((total / change) % 2 == 1) {
                total += change - total % change;
            }
            total += time;
            Set<Integer> newSet = new HashSet<>();
            for (int node : q) {
                for (int newOne : graph.get(node)) {
                    if (newOne == n) {
                        if (first == 0) {
                            first = total;
                        } else if (first < total) {
                            return total;
                        }
                    }
                    if (count[newOne] < 3) {
                        newSet.add(newOne);
                        count[newOne]++;
                    }
                }
            }
            q = newSet;

        }
    }
}
