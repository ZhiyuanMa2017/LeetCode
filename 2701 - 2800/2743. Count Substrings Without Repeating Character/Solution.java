class Solution {
    public int numberOfSpecialSubstrings(String s) {
        int n = s.length();
        boolean[] index = new boolean[26];
        int res = n;
        int left = 0;
        index[s.charAt(0) - 'a'] = true;
        for (int right = 1; right < n; right++) {
            char r = s.charAt(right);
            while (index[r - 'a']) {
                char l = s.charAt(left);
                index[l - 'a'] = false;
                left++;
            }
            index[r - 'a'] = true;
            res += right - left;
        }
        return res;
    }
}
