import java.util.List;

class Solution {
    Trie root;

    class Trie {
        Trie[] children;
        boolean isWord;

        Trie() {
            children = new Trie[26];
            isWord = false;
        }
    }

    public void insert(String word) {
        Trie cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
        }
        cur.isWord = true;
    }

    public int longestValidSubstring(String word, List<String> forbidden) {
        int n = word.length();
        root = new Trie();
        for (String s : forbidden) {
            insert(s);
        }
        int last = n;
        int res = 0;
        for (int start = n - 1; start >= 0; start--) {
            Trie cur = root;
            for (int end = start; end < Math.min(last, start + 10); end++) {
                char c = word.charAt(end);
                if (cur.children[c - 'a'] == null) {
                    break;
                }
                cur = cur.children[c - 'a'];
                if (cur.isWord) {
                    last = end;
                    break;
                }
            }
            res = Math.max(res, last - start);
        }
        return res;
    }
}
