import java.util.Arrays;

class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words, (a, b) -> (a.compareTo(b)));
        Trie root = new Trie();
        root.isWord = true;
        String res = "";
        for (String word : words) {
            Trie cur = root;
            boolean all = true;
            int d = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new Trie();
                    cur.children[index].depth = cur.depth + 1;
                }
                if (!cur.isWord) {
                    all = false;
                }
                cur = cur.children[index];
                d = cur.depth;
            }
            cur.isWord = true;
            if (all) {
                if (d > res.length()) {
                    res = word;
                }
            }
        }
        return res;
    }

    class Trie {
        Trie[] children;
        boolean isWord;
        int depth;

        Trie() {
            children = new Trie[26];
            isWord = false;
            depth = 0;
        }
    }
}
