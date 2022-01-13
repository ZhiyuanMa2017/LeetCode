import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
    Set<String> set;
    int[] memo;
    String str;

    public boolean wordBreak(String s, List<String> wordDict) {
        set = new HashSet<>(wordDict);
        memo = new int[s.length()];
        str = s;
        return dfs(0);
    }

    private boolean dfs(int index) {
        if (index == str.length()) {
            return true;
        }
        if (memo[index] != 0) {
            return memo[index] == 1;
        }
        for (int i = index + 1; i <= str.length(); i++) {
            if (set.contains(str.substring(index, i)) && dfs(i)) {
                memo[index] = 1;
                return true;
            }
        }
        memo[index] = -1;
        return false;
    }
}
