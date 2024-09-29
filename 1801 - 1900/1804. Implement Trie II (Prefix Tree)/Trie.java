class Trie {
    class Node {
        Node[] children;
        int word;
        int pre;

        Node() {
            children = new Node[26];
            word = 0;
            pre = 0;
        }
    }

    Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                cur.children[c - 'a'] = new Node();
            }
            cur = cur.children[c - 'a'];
            cur.pre++;
        }
        cur.word++;
    }

    public int countWordsEqualTo(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.word;
    }

    public int countWordsStartingWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); i++) {
            char c = prefix.charAt(i);
            if (cur.children[c - 'a'] == null) {
                return 0;
            }
            cur = cur.children[c - 'a'];
        }
        return cur.pre;
    }

    public void erase(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (cur.children[c - 'a'].pre == 1) {
                cur.children[c - 'a'] = null;
                return;
            }
            cur = cur.children[c - 'a'];
            cur.pre--;
        }
        cur.word--;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * int param_2 = obj.countWordsEqualTo(word);
 * int param_3 = obj.countWordsStartingWith(prefix);
 * obj.erase(word);
 */
