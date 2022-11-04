class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] alphabet = new int[26];
        for (char c : magazine.toCharArray()) {
            alphabet[c - 'a']++;
        }
        for (int i = 0; i < ransomNote.length(); i++) {
            alphabet[ransomNote.charAt(i) - 'a']--;
            if (alphabet[ransomNote.charAt(i) - 'a'] < 0) {
                return false;
            }
        }
        return true;
    }
}
