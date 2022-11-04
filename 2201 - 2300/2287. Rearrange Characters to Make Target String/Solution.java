class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] from = new int[26];
        for (int i = 0; i < s.length(); i++) {
            from[s.charAt(i) - 'a']++;
        }
        int[] to = new int[26];
        for (int i = 0; i < target.length(); i++) {
            to[target.charAt(i) - 'a']++;
        }
        int res = Integer.MAX_VALUE;
        for (int i = 0; i < 26; i++) {
            if (to[i] > 0) {
                res = Math.min(res, from[i] / to[i]);
            }
        }
        return res;
    }
}
