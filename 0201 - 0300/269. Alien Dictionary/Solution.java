import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

class Solution {
    public String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> inDegree = new HashMap<>();
        for (String word : words) {
            for (char c : word.toCharArray()) {
                inDegree.put(c, 0);
                graph.put(c, new ArrayList<>());
            }
        }
        for (int i = 0; i < words.length - 1; i++) {
            String first = words[i];
            String second = words[i + 1];
            if (first.length() > second.length() && first.startsWith(second)) {
                return "";
            }
            for (int j = 0; j < Math.min(first.length(), second.length()); j++) {
                if (first.charAt(j) != second.charAt(j)) {
                    graph.get(first.charAt(j)).add(second.charAt(j));
                    inDegree.put(second.charAt(j), inDegree.get(second.charAt(j)) + 1);
                    break;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        Queue<Character> queue = new LinkedList<>();
        for (Character c : inDegree.keySet()) {
            if (inDegree.get(c).equals(0)) {
                queue.add(c);
            }
        }
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            sb.append(c);
            for (Character next : graph.get(c)) {
                inDegree.put(next, inDegree.get(next) - 1);
                if (inDegree.get(next) == 0) {
                    queue.offer(next);
                }
            }
        }
        if (sb.length() < inDegree.size()) {
            return "";
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"});
    }
}
