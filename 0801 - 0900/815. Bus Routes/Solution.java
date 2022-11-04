import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        Map<Integer, Set<Integer>> stopToBus = new HashMap();
        for (int i = 0; i < routes.length; i++) {
            for (int j : routes[i]) {
                if (!stopToBus.containsKey(j)) {
                    stopToBus.put(j, new HashSet<>());
                }
                stopToBus.get(j).add(i);
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        boolean[] busSeen = new boolean[routes.length];
        Set<Integer> stopSeen = new HashSet<>();
        queue.offer(new int[]{source, 0});
        stopSeen.add(source);
        while (!queue.isEmpty()) {
            int[] cur = queue.poll();
            int stop = cur[0];
            int count = cur[1];
            if (stop == target) {
                return count;
            }
            for (Integer bus : stopToBus.get(stop)) {
                if (busSeen[bus]) {
                    continue;
                }
                for (int newStop : routes[bus]) {
                    if (!stopSeen.contains(newStop)) {
                        stopSeen.add(newStop);
                        queue.offer(new int[]{newStop, count + 1});
                    }
                }
                busSeen[bus] = true;
            }
        }
        return -1;
    }
}
