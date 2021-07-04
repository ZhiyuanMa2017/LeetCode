import java.util.PriorityQueue;

public class Solution {
    public int eliminateMaximum(int[] dist, int[] speed) {
        PriorityQueue<Double> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < dist.length; i++) {
            priorityQueue.offer(dist[i] * 1.0 / speed[i]);
        }
        int res = 0;
        double time = 0.0;
        while (!priorityQueue.isEmpty()) {
            if (priorityQueue.poll() <= time) {
                return res;
            }
            time++;
            res++;
        }
        return res;
    }
}
