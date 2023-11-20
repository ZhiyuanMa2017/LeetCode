import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        // stop to bus
        // bfs:
        // stop -> all bus has this top -> for every bus -> go to next stop
        // visited stop and visited bus to avoid duplicated visit
        // number of bus : 1 ~ 500
        // number of stop: 10 ^ 5
        int n = routes.length; //1 ~ 500
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            int bus = i;
            for (int stop : routes[bus]) {
                if (!stopToBus.containsKey(stop)) {
                    stopToBus.put(stop, new ArrayList<>());
                }
                stopToBus.get(stop).add(bus);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] busVisited = new boolean[n];
        Set<Integer> stopVisited = new HashSet<>();
        queue.offer(source);
        stopVisited.add(source);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.poll();
                if (curStop == target) {
                    return step;
                }
                if (!stopToBus.containsKey(curStop)) {
                    continue;
                }
                for (Integer nextBus : stopToBus.get(curStop)) {
                    if (busVisited[nextBus]) {
                        continue;
                    }
                    for (int nextStop : routes[nextBus]) {
                        if (stopVisited.contains(nextStop)) {
                            continue;
                        }
                        queue.offer(nextStop);
                        stopVisited.add(nextStop);
                    }
                    busVisited[nextBus] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
