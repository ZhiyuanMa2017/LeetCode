class Solution {
    public long numberOfSubstrings(String s) {
        int n = s.length();
        int[] count = new int[26];
        long res = n;
        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            res += count[c - 'a'];
            count[c - 'a']++;
        }
        return res;
    }
}
