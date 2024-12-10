import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class AutocompleteSystem {
    Trie root;
    Trie cur;
    Trie broken;
    String prefix;

    public AutocompleteSystem(String[] sentences, int[] times) {
        root = new Trie();
        cur = root;
        broken = new Trie();
        prefix = "";
        for (int i = 0; i < sentences.length; i++) {
            add(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if (c == '#') {
            add(prefix, 1);
            prefix = "";
            cur = root;
            return new ArrayList<>();
        } else {
            prefix += c;
            int index = c == ' ' ? 26 : c - 'a';
            if (cur.children[index] == null) {
                cur = broken;
                return new ArrayList<>();
            }
            cur = cur.children[index];
            Map<String, Integer> temp = cur.count;
            List<String> list = new ArrayList<>(temp.keySet());
            Collections.sort(list, (a, b) -> (temp.get(a).equals(temp.get(b)) ? a.compareTo(b) : temp.get(b) - temp.get(a)));
            List<String> res = new ArrayList<>();
            int count = 3;
            for (int i = 0; i < Math.min(3, list.size()); i++) {
                res.add(list.get(i));
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
