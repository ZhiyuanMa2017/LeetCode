import java.util.PriorityQueue;

class Solution {
    public int[] assignTasks(int[] servers, int[] tasks) {
        PriorityQueue<int[]> free = new PriorityQueue<>((a, b) -> a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]);
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> a[2] == b[2] ? (a[0] == b[0] ? a[1] - b[1] : a[0] - b[0]) : a[2] - b[2]);
        for (int i = 0; i < servers.length; i++) {
            free.offer(new int[]{servers[i], i, 0});
        }
        int[] res = new int[tasks.length];
        for (int i = 0; i < tasks.length; i++) {
            while (!busy.isEmpty() && busy.peek()[2] <= i) {
                free.offer(busy.poll());
            }
            if (free.isEmpty()) {
                int[] first = busy.poll();
                int index = first[1];
                res[i] = index;
                first[2] += tasks[i];
                busy.offer(first);
            } else {
                int[] first = free.poll();
                int index = first[1];
                res[i] = index;
                first[2] = i + tasks[i];
                busy.offer(first);
            }
        }
        return res;
    }
}
