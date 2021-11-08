import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

class Solution {
    String S;
    Set<String> wordSet;
    List<String> res;

    public List<String> wordBreak(String s, List<String> wordDict) {
        S = s;
        wordSet = new HashSet<>(wordDict);
        res = new ArrayList<>();
        backtrack(0, new LinkedList<>());
        return res;
    }

    private void backtrack(int start, LinkedList<String> path) {
        if (start == S.length()) {
            res.add(String.join(" ", path));
        }
        for (int i = start; i < S.length(); i++) {
            String cur = S.substring(start, i + 1);
            if (wordSet.contains(cur)) {
                path.add(cur);
                backtrack(i + 1, path);
                path.removeLast();
            }
        }
    }
}
