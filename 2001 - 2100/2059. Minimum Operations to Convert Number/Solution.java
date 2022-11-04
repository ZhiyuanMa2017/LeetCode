import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minimumOperations(int[] nums, int start, int goal) {
        Set<Integer> set = new HashSet<>();
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        int round = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            round++;
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (set.contains(cur)) {
                    continue;
                }
                set.add(cur);
                for (int j = 0; j < nums.length; j++) {
                    int add = cur + nums[j];
                    int subtract = cur - nums[j];
                    int xor = cur ^ nums[j];
                    if (add == goal || subtract == goal || xor == goal) {
                        return round;
                    }
                    if (add >= 0 && add <= 1000 && !set.contains(add)) {
                        queue.offer(add);
                    }
                    if (subtract >= 0 && subtract <= 1000 && !set.contains(subtract)) {
                        queue.offer(subtract);
                    }
                    if (xor >= 0 && xor <= 1000 && !set.contains(xor)) {
                        queue.offer(xor);
                    }
                }
            }
        }
        return -1;
    }
}
