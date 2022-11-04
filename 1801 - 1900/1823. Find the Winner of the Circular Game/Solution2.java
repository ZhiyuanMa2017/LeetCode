import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (queue.size() > 1) {
            int count = k;
            while (count > 1) {
                queue.offer(queue.poll());
                count--;
            }
            queue.poll();
        }
        return queue.poll();
    }
}
