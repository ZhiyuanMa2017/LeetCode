class WordDictionary {

    private TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode cur = root;
        for (int i = 0; i < word.length(); i++) {
            int index = word.charAt(i) - 'a';
            if (cur.children[index] == null) {
                cur.children[index] = new TrieNode();
            }
            cur = cur.children[index];
        }
        cur.isWord = true;
    }

    public boolean search(String word) {
        return dfsSearch(word, root, 0);
    }

    private boolean dfsSearch(String word, TrieNode node, int i) {
        if (i == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(i);
        if (c == '.') {
            for (int j = 0; j < 26; j++) {
                if (node.children[j] != null && dfsSearch(word, node.children[j], i + 1)) {
                    return true;
                }
            }
            return false;
        } else {
            if (node.children[c - 'a'] == null) {
                return false;
            }
            return dfsSearch(word, node.children[c - 'a'], i + 1);
        }
    }

    class TrieNode {
        TrieNode[] children;
        boolean isWord;

        TrieNode() {
            children = new TrieNode[26];
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
