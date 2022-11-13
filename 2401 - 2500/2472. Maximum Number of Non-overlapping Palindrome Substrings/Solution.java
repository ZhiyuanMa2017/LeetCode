import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public int maxPalindromes(String s, int k) {
        int n = s.length();
        char[] chars = s.toCharArray();
        Map<Integer, List<Integer>> ps = new HashMap<>();
        for (int i = 0; i < n; i++) {
            addP(chars, i, ps, k);
        }
        int[] dp = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            dp[i] = Math.max(dp[i], dp[i - 1]);
            int end = i - 1;
            if (ps.containsKey(end)) {
                for (Integer len : ps.get(end)) {
                    int start = end - len;
                    dp[i] = Math.max(dp[i], dp[start + 1] + 1);
                }
            }
        }
        return dp[n];
    }

    private void addP(char[] chars, int mid, Map<Integer, List<Integer>> map, int k) {
        int start = mid;
        int end = mid;
        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            int len = end - start + 1;
            if (len >= k) {
                if (!map.containsKey(end)) {
                    map.put(end, new ArrayList<>());
                }
                map.get(end).add(len);
            }
            if (len > k + 1) {
                break;
            }
            start--;
            end++;
        }
        start = mid;
        end = mid + 1;
        while (start >= 0 && end < chars.length && chars[start] == chars[end]) {
            int len = end - start + 1;
            if (len >= k) {
                if (!map.containsKey(end)) {
                    map.put(end, new ArrayList<>());
                }
                map.get(end).add(len);
            }
            if (len > k + 1) {
                break;
            }
            start--;
            end++;
        }
    }
}
