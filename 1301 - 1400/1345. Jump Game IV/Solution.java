import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public int minJumps(int[] arr) {
        int n = arr.length;
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            map.putIfAbsent(arr[i], new ArrayList<>());
            map.get(arr[i]).add(i);
        }
        Queue<Integer> q = new LinkedList<>();
        q.offer(0);
        boolean[] visited = new boolean[n];
        visited[0] = true;
        int level = 0;
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Integer node = q.poll();
                if (node == n - 1) {
                    return level;
                }
                if (node + 1 < n && !visited[node + 1]) {
                    q.offer(node + 1);
                    visited[node + 1] = true;
                }
                if (node - 1 >= 0 && !visited[node - 1]) {
                    q.offer(node - 1);
                    visited[node - 1] = true;
                }
                if (map.containsKey(arr[node])) {
                    for (Integer next : map.get(arr[node])) {
                        if (!visited[next]) {
                            q.offer(next);
                            visited[next] = true;
                        }
                    }
                    map.remove(arr[node]);
                }

            }
            level++;
        }
        return -1;
    }
}
