import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Leaderboard {
    Map<Integer, Integer> map;

    public Leaderboard() {
        map = new HashMap<>();
    }

    public void addScore(int playerId, int score) {
        map.put(playerId, map.getOrDefault(playerId, 0) + score);
    }

    public int top(int K) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int sum = 0;
        for (Integer integer : map.keySet()) {
            pq.add(map.get(integer));
            sum += map.get(integer);
            if (pq.size() > K) {
                sum -= pq.poll();
            }
        }
        return sum;
    }

    public void reset(int playerId) {
        map.remove(playerId);
    }
}

/**
 * Your Leaderboard object will be instantiated and called as such:
 * Leaderboard obj = new Leaderboard();
 * obj.addScore(playerId,score);
 * int param_2 = obj.top(K);
 * obj.reset(playerId);
 */
