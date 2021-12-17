import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution2 {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (source == target) {
            return 0;
        }
        int busCount = routes.length;
        Map<Integer, List<Integer>> stopToBus = new HashMap<>();
        boolean[][] busConnected = new boolean[busCount][busCount];
        for (int i = 0; i < busCount; i++) {
            for (int stop : routes[i]) {
                List<Integer> busAtStop = stopToBus.getOrDefault(stop, new ArrayList<>());
                for (Integer busNumber : busAtStop) {
                    busConnected[i][busNumber] = true;
                    busConnected[busNumber][i] = true;
                }
                busAtStop.add(i);
                stopToBus.put(stop, busAtStop);
            }
        }
        int[] dis = new int[busCount];
        Queue<Integer> queue = new LinkedList<>();
        for (Integer sourceBus : stopToBus.get(source)) {
            queue.offer(sourceBus);
            dis[sourceBus] = 1;
        }
        while (!queue.isEmpty()) {
            int newBus = queue.poll();
            for (int nextBus = 0; nextBus < busCount; nextBus++) {
                if (busConnected[newBus][nextBus] && dis[nextBus] == 0) {
                    dis[nextBus] = dis[newBus] + 1;
                    queue.offer(nextBus);
                }
            }
        }
        int res = Integer.MAX_VALUE;
        for (Integer targetBus : stopToBus.getOrDefault(target, new ArrayList<>())) {
            if (dis[targetBus] != 0) {
                res = Math.min(res, dis[targetBus]);
            }
        }
        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
    
