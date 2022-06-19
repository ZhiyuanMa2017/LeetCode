class Solution {
    public int longestSubsequence(String s, int k) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '0') {
                count++;
            }
        }
        int cur = 0;
        int pow = 1;
        for (int i = s.length() - 1; i > 0; i--) {
            if (cur + pow > k) {
                break;
            }
            if (s.charAt(i) == '1') {
                cur += pow;
                count++;
            }
            pow *= 2;
        }
        return count;
    }
}
