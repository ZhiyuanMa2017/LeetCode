import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int leastBricks(List<List<Integer>> wall) {
        Map<Integer, Integer> map = new HashMap<>();
        int row = wall.size();
        int maxEdges = 0;
        for (int i = 0; i < row; i++) {
            int nowEdge = 0;
            for (int j = 0; j < wall.get(i).size() - 1; j++) {
                nowEdge += wall.get(i).get(j);
                map.put(nowEdge, map.getOrDefault(nowEdge, 0) + 1);
                maxEdges = Math.max(maxEdges, map.get(nowEdge));
            }
        }
        return row - maxEdges;
    }
}
