class Solution {
    public int countCharacters(String[] words, String chars) {
        int[] count = new int[26];
        for (int i = 0; i < chars.length(); i++) {
            count[chars.charAt(i) - 'a']++;
        }
        int res = 0;
        for (String word : words) {
            int[] cur = new int[26];
            boolean flag = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur[c - 'a']++;
                if (cur[c - 'a'] > count[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res += word.length();
            }
        }
        return res;
    }
}
