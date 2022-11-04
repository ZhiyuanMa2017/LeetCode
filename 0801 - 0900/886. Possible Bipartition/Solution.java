import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n + 1; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] dislike : dislikes) {
            graph.get(dislike[0]).add(dislike[1]);
            graph.get(dislike[1]).add(dislike[0]);
        }
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            if (count[i] != 0) {
                continue;
            }
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(i);
            count[i] = 1;
            int color = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int j = 0; j < size; j++) {
                    int cur = queue.poll();
                    for (Integer integer : graph.get(cur)) {
                        if (count[integer] == 0) {
                            count[integer] = color;
                            queue.offer(integer);
                        } else if (count[integer] != color) {
                            return false;
                        }
                    }
                }
                color = -color;
            }
        }
        return true;
    }
}
