import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    List<String> res;
    Map<String, PriorityQueue<String>> flights;

    public List<String> findItinerary(List<List<String>> tickets) {
        res = new ArrayList<>();
        flights = new HashMap<>();
        for (List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            if (!flights.containsKey(from)) {
                flights.put(from, new PriorityQueue<>());
            }
            flights.get(from).offer(to);
        }
        dfs("JFK");
        return res;
    }

    private void dfs(String airport) {
        while (flights.containsKey(airport) && !flights.get(airport).isEmpty()) {
            dfs(flights.get(airport).poll());
        }
        res.add(0, airport);
    }
}
