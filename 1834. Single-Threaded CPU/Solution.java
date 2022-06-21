import java.util.Arrays;
import java.util.PriorityQueue;

class Solution {
    public int[] getOrder(int[][] tasks) {
        int[][] tasksWithIndex = new int[tasks.length][3];
        for (int i = 0; i < tasks.length; i++) {
            tasksWithIndex[i] = new int[]{tasks[i][0], tasks[i][1], i};
        }
        Arrays.sort(tasksWithIndex, (a, b) -> a[0] - b[0]);
        System.out.println(Arrays.deepToString(tasksWithIndex));
        int time = 1;
        int[] res = new int[tasks.length];
        int i = 0;
        int index = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? a[2] - b[2] : a[1] - b[1]);
        while (i < tasksWithIndex.length) {
            while (index < tasks.length && tasksWithIndex[index][0] <= time) {
                pq.offer(tasksWithIndex[index]);
                index++;
            }
            if (pq.isEmpty()) {
                time = tasksWithIndex[index][0];
            } else {
                int[] task = pq.poll();
                res[i] = task[2];
                i++;
                time += task[1];
            }
        }
        return res;
    }
}
