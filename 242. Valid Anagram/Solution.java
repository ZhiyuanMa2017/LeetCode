class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alphabet = new int[26];
        for (char c : s.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            alphabet[c - 'a']--;
            if (alphabet[c - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
