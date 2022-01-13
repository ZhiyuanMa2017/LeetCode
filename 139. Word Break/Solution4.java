import java.util.List;

class Solution4 {
    Trie root;

    public boolean wordBreak(String s, List<String> wordDict) {
        root = new Trie();
        for (String s1 : wordDict) {
            insert(s1);
        }
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;
        for (int i = s.length() - 1; i >= 0; i--) {
            Trie cur = root;
            int index = i;
            while (index < s.length()) {
                int c = s.charAt(index) - 'a';
                if (cur.children[c] == null) {
                    break;
                }
                cur = cur.children[c];
                index++;
                if (cur.isWord && dp[index]) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[0];
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
