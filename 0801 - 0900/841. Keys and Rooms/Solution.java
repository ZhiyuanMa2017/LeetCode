import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class Solution {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[1001];
        visited[0] = true;
        int count = 1;
        while (!q.isEmpty()) {
            int cur = q.poll();
            List<Integer> curList = rooms.get(cur);
            for (int next : curList) {
                if (!visited[next]) {
                    count++;
                    visited[next] = true;
                    q.offer(next);
                }
            }
        }
        return count == rooms.size();
    }
}
