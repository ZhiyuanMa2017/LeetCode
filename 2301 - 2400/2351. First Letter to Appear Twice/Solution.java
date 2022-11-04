class Solution {
    public char repeatedCharacter(String s) {
        boolean[] seen = new boolean[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (seen[c - 'a']) {
                return c;
            }
            seen[c - 'a'] = true;
        }
        return 'a';
    }
}
