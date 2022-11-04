class Solution {
    public int minSteps(String s, String t) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = 0; i < t.length(); i++) {
            int index = t.charAt(i) - 'a';
            if (count[index] > 0) {
                count[index]--;
            }
        }
        int res = 0;
        for (int i = 0; i < 26; i++) {
            res += count[i];
        }
        return res;
    }
}
