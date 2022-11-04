import java.util.List;

class Solution3 {
    Trie root;
    String str;
    int[] memo;

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for (String s1 : wordDict) {
            insert(s1);
        }
        str = s;
        memo = new int[s.length()];
        return dfs(0);
    }

    private boolean dfs(int begin) {
        if (begin == str.length()) {
            return true;
        }
        if (memo[begin] != 0) {
            return memo[begin] == 1;
        }
        Trie cur = root;

        for (int i = begin; i < str.length(); i++) {
            int c = str.charAt(i) - 'a';
            if (cur.children[c] != null) {
                cur = cur.children[c];
                if (cur.isWord && dfs(i + 1)) {
                    memo[begin] = 1;
                    return true;
                }
            } else {
                break;
            }
        }
        memo[begin] = -1;
        return false;
    }

    private void insert(String s) {
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
