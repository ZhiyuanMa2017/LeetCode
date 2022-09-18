class Solution {
    Trie root;

    public int[] sumPrefixScores(String[] words) {
        root = new Trie();
        for (String word : words) {
            insert(word);
        }
        int[] res = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Trie cur = root;
            int cc = 0;
            for (int j = 0; j < word.length(); j++) {
                int c = word.charAt(j) - 'a';
                cur = cur.children[c];
                cc += cur.count;
            }
            res[i] = cc;
        }
        return res;
    }

    private void insert(String s) {
        Trie cur = root;
        for (int i = 0; i < s.length(); i++) {
            int c = s.charAt(i) - 'a';
            if (cur.children[c] == null) {
                cur.children[c] = new Trie();
            }
            cur = cur.children[c];
            cur.count++;
        }
    }

    class Trie {
        Trie[] children;
        int count;

        Trie() {
            children = new Trie[26];
            count = 0;
        }
    }
}
