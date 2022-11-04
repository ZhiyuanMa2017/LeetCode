class Solution {
    public int numberOfSubstrings(String s) {
        int res = 0;
        int[] count = new int[3];
        int right = 0;
        for (int left = 0; left < s.length(); left++) {
            while (right < s.length() && (count[0] <= 0 || count[1] <= 0 || count[2] <= 0)) {
                count[s.charAt(right) - 'a']++;
                right++;
            }
            if (count[0] > 0 && count[1] > 0 && count[2] > 0) {
                res += s.length() - right + 1;
            }
            count[s.charAt(left) - 'a']--;
        }
        return res;
    }
}
