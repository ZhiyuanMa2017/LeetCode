import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public long minimumFuelCost(int[][] roads, int seats) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        Map<Integer, Integer> degree = new HashMap<>();
        Map<Integer, Long> cities = new HashMap<>();
        for (int[] road : roads) {
            int one = road[0];
            int two = road[1];
            cities.put(one, 1L);
            cities.put(two, 1L);
            degree.put(one, degree.getOrDefault(one, 0) + 1);
            degree.put(two, degree.getOrDefault(two, 0) + 1);
            if (!graph.containsKey(one)) {
                graph.put(one, new ArrayList<>());
            }
            if (!graph.containsKey(two)) {
                graph.put(two, new ArrayList<>());
            }
            graph.get(one).add(two);
            graph.get(two).add(one);
        }

        Queue<Integer> q = new LinkedList<>();
        for (Integer integer : degree.keySet()) {
            if (degree.get(integer) == 1) {
                q.add(integer);
            }
        }
        long res = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == 0) {
                    break;
                }
                long status = cities.get(cur);
                res += (status + seats - 1) / seats;
                for (Integer neighbor : graph.get(cur)) {
                    if (degree.get(neighbor) <= 1) {
                        continue;
                    }
                    degree.put(neighbor, degree.get(neighbor) - 1);
                    cities.put(neighbor, cities.get(neighbor) + status);
                    if (degree.get(neighbor) == 1) {
                        q.offer(neighbor);
                    }
                }
            }
        }
        return res;
    }
}
