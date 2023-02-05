import java.util.PriorityQueue;

class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int gift : gifts) {
            pq.offer(gift);
        }
        for (int i = 0; i < k; i++) {
            int cur = pq.poll();
            int remain = (int) Math.sqrt(cur);
            pq.offer(remain);
        }
        long res = 0;
        for (Integer integer : pq) {
            res += integer;
        }
        return res;
    }
}
