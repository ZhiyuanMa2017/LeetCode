import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    Trie root;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        root = new Trie();
        Arrays.sort(words, (a, b) -> (a.length() - b.length()));
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (word.length() == 0) {
                continue;
            }
            if (check(word, 0)) {
                res.add(word);
            } else {
                add(word);
            }
        }
        return res;
    }

    private boolean check(String s, int index) {
        Trie cur = root;
        if (index == s.length()) {
            return true;
        }
        for (int i = index; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return false;
            }
            if (cur.children[c - 'a'].isWord) {
                if (check(s, i + 1)) {
                    return true;
                }
            }
            cur = cur.children[c - 'a'];
        }
        return false;
    }

    private void add(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            if (cur.children[word.charAt(i) - 'a'] == null) {
                cur.children[word.charAt(i) - 'a'] = new Trie();
            }
            cur = cur.children[word.charAt(i) - 'a'];
        }
        cur.isWord = true;
    }

    class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }
}
