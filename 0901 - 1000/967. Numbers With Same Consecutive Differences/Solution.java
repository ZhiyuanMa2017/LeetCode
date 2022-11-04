import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] numsSameConsecDiff(int n, int k) {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < 10; i++) {
            queue.offer(i);
        }
        for (int i = 1; i < n; i++) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                int unit = cur % 10;
                if (unit + k <= 9) {
                    queue.offer(cur * 10 + unit + k);
                }
                if (k != 0 && unit - k >= 0) {
                    queue.offer(cur * 10 + unit - k);
                }
            }
        }
        int[] res = new int[queue.size()];
        int size = queue.size();
        for (int i = 0; i < size; i++) {
            res[i] = queue.poll();
        }
        return res;
    }
}
