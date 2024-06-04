class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[58];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'A']++;
        }
        int odd = 0;
        int res = 0;
        for (int i = 0; i < 58; i++) {
            if (count[i] % 2 == 1) {
                odd = 1;
                res += count[i] - 1;
            } else {
                res += count[i];
            }
        }
        return res + odd;
    }
}
