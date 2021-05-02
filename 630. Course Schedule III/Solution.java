import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution {
    public int scheduleCourse(int[][] courses) {
        Arrays.sort(courses, Comparator.comparingInt(a -> a[1]));
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int countTime = 0;
        for (int[] c : courses) {
            if (countTime + c[0] <= c[1]) {
                pq.offer(c[0]);
                countTime += c[0];
            } else if (!pq.isEmpty() && pq.peek() > c[0]) {
                countTime += c[0] - pq.poll();
                pq.offer(c[0]);
            }
        }
        return pq.size();
    }
}
