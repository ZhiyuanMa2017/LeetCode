import java.util.LinkedList;
import java.util.Queue;

class Solution2 {
    public boolean canReach(int[] arr, int start) {
        if (arr[start] == 0) {
            return true;
        }
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(start);
        boolean[] visited = new boolean[arr.length];
        visited[start] = true;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int index = queue.poll();
                int newOne = index + arr[index];
                int newTwo = index - arr[index];
                if (newOne < arr.length && !visited[newOne]) {
                    if (arr[newOne] == 0) {
                        return true;
                    }
                    queue.offer(newOne);
                    visited[newOne] = true;
                }
                if (newTwo >= 0 && !visited[newTwo]) {
                    if (arr[newTwo] == 0) {
                        return true;
                    }
                    queue.offer(newTwo);
                    visited[newTwo] = true;
                }
            }
        }
        return false;
    }
}
