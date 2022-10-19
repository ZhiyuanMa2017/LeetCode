import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    List<String> res;
    int kk;

    public List<String> topKFrequent(String[] words, int k) {
        res = new ArrayList<>();
        kk = k;
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        Trie[] bucket = new Trie[words.length];
        for (String s : map.keySet()) {
            int count = map.get(s);
            if (bucket[count] == null) {
                bucket[count] = new Trie();
            }
            insert(bucket[count], s);
        }
        for (int i = words.length - 1; i >= 0; i--) {
            if (bucket[i] != null) {
                dfs(bucket[i], new StringBuilder());
            }
            if (kk == 0) {
                break;
            }
        }
        return res;
    }

    private void dfs(Trie root, StringBuilder sb) {
        if (kk == 0) {
            return;
        }
        if (root.isWord) {
            kk--;
            res.add(sb.toString());
        }
        for (int i = 0; i < 26; i++) {
            if (root.children[i] != null) {
                sb.append((char) ('a' + i));
                dfs(root.children[i], sb);
                sb.setLength(sb.length() - 1);
            }
        }
    }

    private void insert(Trie root, String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new Trie();
            }
            cur = cur.children[c];
        }
        cur.isWord = true;
    }

    class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
        }
    }
}
