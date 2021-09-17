class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int i = 0;
        int[] alphabet = new int[26];
        int curMaxC = 0;
        int curMaxLength = 0;
        for (int j = 0; j < n; j++) {
            alphabet[s.charAt(j) - 'A']++;
            curMaxC = Math.max(curMaxC, alphabet[s.charAt(j) - 'A']);
            while (j - i + 1 - curMaxC > k) {
                alphabet[s.charAt(i) - 'A']--;
                i++;
            }
            curMaxLength = Math.max(j - i + 1, curMaxLength);
        }
        return curMaxLength;
    }
}
