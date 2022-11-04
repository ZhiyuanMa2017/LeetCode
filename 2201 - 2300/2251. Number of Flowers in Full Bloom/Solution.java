import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[] fullBloomFlowers(int[][] flowers, int[] persons) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        Arrays.sort(flowers, (a, b) -> a[0] - b[0]);
        Map<Integer, Integer> map = new HashMap<>();
        int[] p = Arrays.copyOf(persons, persons.length);
        Arrays.sort(p);
        int index = 0;
        for (int i : p) {
            if (map.containsKey(i)) {
                continue;
            }
            while (index < flowers.length && flowers[index][0] <= i) {
                pq.offer(flowers[index]);
                index++;
            }
            while (!pq.isEmpty() && pq.peek()[1] < i) {
                pq.poll();
            }
            map.put(i, pq.size());
        }
        int[] res = new int[persons.length];
        for (int i = 0; i < persons.length; i++) {
            res[i] = map.get(persons[i]);
        }
        return res;
    }
}
