class Solution {
    public int calculateTime(String keyboard, String word) {
        int[] index = new int[26];
        for (int i = 0; i < keyboard.length(); i++) {
            index[keyboard.charAt(i) - 'a'] = i;
        }
        int prev = 0;
        int res = 0;
        for (int i = 0; i < word.length(); i++) {
            int cur = index[word.charAt(i) - 'a'];
            res += Math.abs(cur - prev);
            prev = cur;
        }
        return res;
    }
}
