import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
        }
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> b.count - a.count);
        for (Character c : map.keySet()) {
            pq.offer(new Node(c, map.get(c)));
        }
        StringBuilder sb = new StringBuilder();
        while (!pq.isEmpty()) {
            Node cur = pq.poll();
            sb.append(String.valueOf(cur.c).repeat(cur.count));
        }
        return sb.toString();
    }

    class Node {
        char c;
        int count;

        Node(char cc, int ii) {
            c = cc;
            count = ii;
        }
    }
}
