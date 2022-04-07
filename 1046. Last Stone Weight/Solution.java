import java.util.PriorityQueue;

class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int stone : stones) {
            pq.offer(stone);
        }
        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            if (one > two) {
                pq.offer(one - two);
            }
        }
        return pq.size() == 0 ? 0 : pq.poll();
    }
}
