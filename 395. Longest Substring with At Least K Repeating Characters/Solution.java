class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] charfreq = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charfreq[s.charAt(i) - 'a'] += 1;
        }
        
        boolean valid = true;
        int res = 0;
        int start = 0;
        for (int i = 0; i < s.length(); i++) {
            if (charfreq[s.charAt(i) - 'a'] < k) {
                res = Math.max(res, longestSubstring(s.substring(start, i), k));
                start = i + 1;
                valid = false;
            }
        }
        if (valid) {
            return s.length();
        } else {
            return Math.max(res, longestSubstring(s.substring(start), k));
        }
    }
}