import java.util.PriorityQueue;

class Solution {
    public int minRefuelStops(int target, int startFuel, int[][] stations) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        int i = 0;
        int res = 0;
        int cur = startFuel;
        while (cur < target) {
            while (i < stations.length && stations[i][0] <= cur) {
                priorityQueue.offer(-stations[i][1]);
                i++;
            }
            if (priorityQueue.isEmpty()) {
                return -1;
            }
            cur += -priorityQueue.poll();
            res++;
        }
        return res;
    }
}
