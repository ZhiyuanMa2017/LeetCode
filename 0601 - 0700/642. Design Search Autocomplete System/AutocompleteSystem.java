import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

class AutocompleteSystem {
    Trie root;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            return new ArrayList<>();
        } else {
            prefix += c;
            Trie cur = root;
            for (int i = 0; i < prefix.length(); i++) {
                int index = prefix.charAt(i) == ' ' ? 26 : prefix.charAt(i) - 'a';
                if (cur.children[index] == null) {
                    return new ArrayList<>();
                }
                cur = cur.children[index];
            }
            Map<String, Integer> temp = cur.count;
            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());
            for (Map.Entry<String, Integer> entry : temp.entrySet()) {
                pq.add(entry);
            }
            List<String> res = new ArrayList<>();
            int count = 3;
            while (!pq.isEmpty() && count > 0) {
                res.add(pq.poll().getKey());
                count--;
            }
            return res;
        }
    }

    private void add(String s, int time) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            int index = s.charAt(i) == ' ' ? 26 : s.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new Trie();
            }
            cur = cur.children[index];
            cur.count.put(s, cur.count.getOrDefault(s, 0) + time);
        }
    }

    class Trie {
        Trie[] children;
        Map<String, Integer> count;

        Trie() {
            children = new Trie[27];
            count = new HashMap<>();
        }
    }

}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
