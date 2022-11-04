class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int[] mapping = new int[26];
        for (int i = 0; i < order.length(); i++) {
            mapping[order.charAt(i) - 'a'] = i;
        }
        for (int i = 0; i < words.length - 1; i++) {
            if (bigger(words[i], words[i + 1], mapping)) {
                return false;
            }
        }
        return true;
    }

    private boolean bigger(String s1, String s2, int[] m) {
        int a = s1.length();
        int b = s2.length();
        for (int i = 0; i < a && i < b; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return m[s1.charAt(i) - 'a'] > m[s2.charAt(i) - 'a'];
            }
        }
        return a > b;
    }
}
