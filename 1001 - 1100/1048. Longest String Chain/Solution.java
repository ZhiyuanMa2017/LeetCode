import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestStrChain(String[] words) {
        Map<String, Integer> dp = new HashMap<>();
        int res = 0;
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        for (String word : words) {
            int curMax = 0;
            for (int i = 0; i < word.length(); i++) {
                String prev = word.substring(0, i) + word.substring(i + 1);
                curMax = Math.max(curMax, dp.getOrDefault(prev, 0) + 1);
            }
            dp.put(word, curMax);
            res = Math.max(res, curMax);
        }
        return res;
    }
}
