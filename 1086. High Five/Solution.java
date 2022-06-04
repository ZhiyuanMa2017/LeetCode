import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            int id = item[0];
            int score = item[1];
            if (!map.containsKey(id)) {
                map.put(id, new PriorityQueue<>());
            }
            map.get(id).add(score);
            if (map.get(id).size() > 5) {
                map.get(id).poll();
            }
        }
        int[][] res = new int[map.keySet().size()][2];
        int index = 0;
        for (Integer key : map.keySet()) {
            int score = 0;
            PriorityQueue<Integer> scores = map.get(key);
            while (!scores.isEmpty()) {
                score += scores.poll();
            }
            score /= 5;
            res[index] = new int[]{key, score};
            index++;
        }
        return res;
    }
}
