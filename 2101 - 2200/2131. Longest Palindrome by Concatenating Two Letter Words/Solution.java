import java.util.HashMap;
import java.util.Map;

class Solution {
    public int longestPalindrome(String[] words) {
        Map<String, Integer> map = new HashMap<>();
        for (String word : words) {
            map.put(word, map.getOrDefault(word, 0) + 1);
        }
        int pairs = 0;
        int singlePalindrome = 0;
        int palindromePairs = 0;
        for (String s : map.keySet()) {
            if (s.charAt(0) == s.charAt(1)) {
                int count = map.get(s);
                singlePalindrome += count % 2;
                palindromePairs += count / 2;
            } else {
                String reverse = new StringBuilder(s).reverse().toString();
                if (map.containsKey(reverse)) {
                    int count = Math.min(map.get(s), map.get(reverse));
                    pairs += count;
                }
            }
        }
        int res = singlePalindrome > 0 ? 2 : 0;
        res += pairs * 2 + palindromePairs * 4;
        return res;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        s.longestPalindrome(new String[]{"em", "pe", "mp", "ee", "pp", "me", "ep", "em", "em", "me"});
    }
}
