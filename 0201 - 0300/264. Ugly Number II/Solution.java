import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

class Solution {
    public int nthUglyNumber(int n) {
        int[] factors = new int[]{2, 3, 5};
        Set<Long> set = new HashSet<>();
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        set.add(1L);
        priorityQueue.add(1L);
        for (int i = 0; i < n; i++) {
            long number = priorityQueue.poll();
            if (i == n - 1) {
                return (int) number;
            }
            for (int factor : factors) {
                long newNum = number * factor;
                if (!set.contains(newNum)) {
                    set.add(newNum);
                    priorityQueue.add(newNum);
                }
            }
        }
        return -1;
    }
}
