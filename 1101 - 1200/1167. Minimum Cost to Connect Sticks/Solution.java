import java.util.PriorityQueue;

class Solution {
    public int connectSticks(int[] sticks) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int stick : sticks) {
            pq.add(stick);
        }
        int res = 0;
        while (pq.size() > 1) {
            int one = pq.poll();
            int two = pq.poll();
            res += one + two;
            pq.add(one + two);
        }
        return res;
    }
}
