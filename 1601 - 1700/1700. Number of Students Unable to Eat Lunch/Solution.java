import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int countStudents(int[] students, int[] sandwiches) {
        Queue<Integer> queue = new LinkedList<>();
        for (int num : students) {
            queue.offer(num);
        }
        int index = 0;
        int n = sandwiches.length;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == sandwiches[index]) {
                    index++;
                } else {
                    queue.offer(cur);
                }
                if (i == n) {
                    return 0;
                }
            }
            if (queue.size() == size) {
                break;
            }
        }
        return n - index;
    }
}
