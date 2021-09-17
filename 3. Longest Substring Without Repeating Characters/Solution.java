import java.util.HashSet;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int i = 0;
        int j = 0;
        HashSet<Character> hs = new HashSet<>();
        while (j < s.length()) {
            if (!hs.contains(s.charAt(j))) {
                hs.add(s.charAt(j));
                j++;
                res = Math.max(res, hs.size());
            } else {
                hs.remove(s.charAt(i));
                i++;
            }
        }
        return res;
    }
}
