class WordFilter {

    Trie root;

    WordFilter(String[] words) {
        root = new Trie();
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            String twoWord = word + '{' + word;
            for (int j = 0; j < word.length() + 1; j++) {
                Trie cur = root;
                for (int k = j; k < twoWord.length(); k++) {
                    int index = twoWord.charAt(k) - 'a';
                    if (cur.children[index] == null) {
                        cur.children[index] = new Trie();
                    }
                    cur = cur.children[index];
                    cur.weight = i;
                }
            }
        }
    }

    public int f(String prefix, String suffix) {
        Trie cur = root;
        String searchWord = suffix + '{' + prefix;
        for (char c : searchWord.toCharArray()) {
            if (cur.children[c - 'a'] == null) {
                return -1;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.weight;
    }

    class Trie {

        Trie[] children;
        int weight;

        Trie() {
            children = new Trie[27];
            weight = 0;
        }
    }
}
// apple{apple

/**
 * Your WordFilter object will be instantiated and called as such:
 * WordFilter obj = new WordFilter(words);
 * int param_1 = obj.f(prefix,suffix);
 */
