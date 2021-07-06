import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int a : arr) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        pq.addAll(map.values());
        int counter = 0;
        int res = 0;
        while (!pq.isEmpty()) {
            counter += pq.poll();
            res++;
            if (counter * 2 >= arr.length) {
                return res;
            }
        }
        return -1;
    }
}
