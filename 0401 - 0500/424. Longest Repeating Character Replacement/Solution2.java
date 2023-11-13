class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int[] alphabet = new int[26];
        int maxC = 0;
        for (int j = 0; j < n; j++) {
            alphabet[s.charAt(j) - 'A']++;
            maxC = Math.max(maxC, alphabet[s.charAt(j) - 'A']);
            if (j - i + 1 - maxC > k) {
                alphabet[s.charAt(i) - 'A']--;
                i++;
            }
        }
        return n - i;
    }
}
