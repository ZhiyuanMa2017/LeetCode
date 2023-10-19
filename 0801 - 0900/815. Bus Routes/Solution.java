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
        if (source == target) {
            return 0;
        }
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!stopToBus.containsKey(j)) {
                    stopToBus.put(j, new ArrayList<>());
                }
                stopToBus.get(j).add(i);
            }
        }
        Queue<Integer> queue = new ArrayDeque<>();
        boolean[] busSeen = new boolean[routes.length];
        Set<Integer> stopSeen = new HashSet<>();
        queue.offer(source);
        stopSeen.add(source);
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curStop = queue.poll();
                if (curStop == target) {
                    return step;
                }
                for (Integer nextBus : stopToBus.get(curStop)) {
                    if (busSeen[nextBus]) {
                        continue;
                    }
                    for (int nextStop : routes[nextBus]) {
                        if (stopSeen.contains(nextStop)) {
                            continue;
                        }
                        queue.offer(nextStop);
                        stopSeen.add(nextStop);
                    }
                    busSeen[nextBus] = true;
                }
            }
            step++;
        }
        return -1;
    }
}
