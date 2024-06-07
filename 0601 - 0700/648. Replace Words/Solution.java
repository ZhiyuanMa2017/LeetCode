import java.util.List;

class Solution {
    public String replaceWords(List<String> dictionary, String sentence) {
        Trie root = new Trie();
        for (String s : dictionary) {
            insert(root, s);
        }
        String[] words = sentence.split(" ");
        StringBuilder res = new StringBuilder();
        for (String word : words) {
            String s = search(root, word);
            res.append(s).append(" ");
        }
        res.setLength(res.length() - 1);
        return res.toString();
    }

    private String search(Trie root, String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return s;
            }
            cur = cur.children[c - 'a'];
            if (cur.isWord) {
                return s.substring(0, i + 1);
            }
        }
        return s;
    }

    private void insert(Trie root, String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Trie();
            }
            cur = cur.children[c - 'a'];
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
