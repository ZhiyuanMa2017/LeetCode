import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class Solution {
    // DAG: Directed acyclic graph, from end to begin
    Map<String, List<String>> graph;
    List<List<String>> res;

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        graph = new HashMap<>();
        res = new ArrayList<>();
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) {
            return res;
        }
        boolean exits = buildGraph(beginWord, endWord, words);
        if (!exits) {
            return res;
        }
        List<String> path = new ArrayList<>();
        path.add(endWord);
        backtrack(endWord, beginWord, path);
        return res;
    }

    private void backtrack(String end, String begin, List<String> path) {
        if (end.equals(begin)) {
            List<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            res.add(tmp);
            return;
        }

        for (String next : graph.get(end)) {
            path.add(next);
            backtrack(next, begin, path);
            path.remove(path.size() - 1);
        }
    }

    private boolean buildGraph(String begin, String end, Set<String> words) {
        boolean found = false;
        Queue<String> queue = new LinkedList<>();
        Set<String> enQueued = new HashSet<>();
        queue.offer(begin);
        enQueued.add(begin);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> levelVisited = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                List<String> neighbors = getNeighbors(cur, words);
                for (String neighbor : neighbors) {
                    levelVisited.add(neighbor);
                    if (!graph.containsKey(neighbor)) {
                        graph.put(neighbor, new ArrayList<>());
                    }
                    graph.get(neighbor).add(cur);
                    if (!enQueued.contains(neighbor)) {
                        queue.offer(neighbor);
                        enQueued.add(neighbor);
                    }
                    if (neighbor.equals(end)) {
                        found = true;
                    }
                }
            }
            if (found) {
                break;
            }
            for (String s : levelVisited) {
                words.remove(s);
            }
        }
        return found;
    }

    private List<String> getNeighbors(String word, Set<String> words) {
        List<String> neighbors = new ArrayList<>();
        char[] chars = word.toCharArray();
        for (int i = 0; i < word.length(); i++) {
            char c = chars[i];
            for (int j = 0; j < 26; j++) {
                char next = (char) (j + 'a');
                if (next == c) {
                    continue;
                }
                chars[i] = next;
                String nextWord = new String(chars);
                if (!words.contains(nextWord)) {
                    continue;
                }
                neighbors.add(nextWord);
            }
            chars[i] = c;
        }
        return neighbors;
    }
}
