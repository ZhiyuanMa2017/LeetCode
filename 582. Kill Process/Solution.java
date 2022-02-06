import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < pid.size(); i++) {
            graph.put(pid.get(i), new ArrayList<>());
        }
        for (int i = 0; i < ppid.size(); i++) {
            int father = ppid.get(i);
            int self = pid.get(i);
            if (graph.containsKey(father)) {
                graph.get(father).add(self);
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        q.offer(kill);
        while (!q.isEmpty()) {
            int cur = q.poll();
            res.add(cur);
            if (graph.containsKey(cur)) {
                q.addAll(graph.get(cur));
            }
        }
        return res;
    }
}
