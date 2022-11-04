import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution2 {
    Set<Long> set;
    int P = 131;

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        set = new HashSet<>();
        for (String word : words) {
            long hash = 0;
            for (int i = 0; i < word.length(); i++) {
                hash = hash * P + word.charAt(i) - 'a';
            }
            set.add(hash);
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            if (check(word)) {
                res.add(word);
            }
        }
        return res;
    }

    private boolean check(String word) {
        int n = word.length();
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 0;
        for (int i = 0; i <= n; i++) {
            if (dp[i] == -1) {
                continue;
            }
            long hash = 0;
            for (int j = i + 1; j <= n; j++) {
                hash = hash * P + word.charAt(j - 1) - 'a';
                if (set.contains(hash)) {
                    dp[j] = Math.max(dp[j], dp[i] + 1);
                }
            }
            if (dp[n] > 1) {
                return true;
            }
        }
        return false;
    }
}
