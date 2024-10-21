import java.util.HashSet;
import java.util.Set;

class Solution {
    int res;

    public int maxUniqueSplit(String s) {
        res = 0;
        backtrack(s, 0, new HashSet<>());
        return res;
    }

    private void backtrack(String s, int index, Set<String> set) {
        if (index == s.length()) {
            res = Math.max(res, set.size());
            return;
        }
        for (int end = index; end < s.length(); end++) {
            String sub = s.substring(index, end + 1);
            if (!set.contains(sub)) {
                set.add(sub);
                backtrack(s, end + 1, set);
                set.remove(sub);
            }
        }
    }
}
