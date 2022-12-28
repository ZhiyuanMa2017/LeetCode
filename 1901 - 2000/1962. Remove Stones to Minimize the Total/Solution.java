import java.util.PriorityQueue;

class Solution {
    public int minStoneSum(int[] piles, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int total = 0;
        for (int pile : piles) {
            total += pile;
            pq.offer(pile);
        }
        while (k > 0) {
            int cur = pq.poll();
            int half = cur / 2;
            total -= half;
            cur -= half;
            pq.offer(cur);
            k--;
        }
        return total;
    }
}
