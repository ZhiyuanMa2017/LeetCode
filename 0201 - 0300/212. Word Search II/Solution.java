import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();
    char[][] b;

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        b = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(i, j, root);
            }
        }
        return res;
    }

    private void backtracking(int i, int j, TrieNode cur) {
        char c = b[i][j];
        if (c == '+' || cur.children[c - 'a'] == null) {
            return;
        }
        cur = cur.children[c - 'a'];
        if (cur.word != null) {
            res.add(cur.word);
            cur.word = null;
        }
        b[i][j] = '+';
        if (i > 0) {
            backtracking(i - 1, j, cur);
        }
        if (j > 0) {
            backtracking(i, j - 1, cur);
        }
        if (i < b.length - 1) {
            backtracking(i + 1, j, cur);
        }
        if (j < b[0].length - 1) {
            backtracking(i, j + 1, cur);
        }
        b[i][j] = c;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode cur = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (cur.children[index] == null) {
                    cur.children[index] = new TrieNode();
                }
                cur = cur.children[index];
            }
            cur.word = word;
        }
        return root;
    }

    class TrieNode {
        public TrieNode[] children;
        public String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
