class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length() > s2.length()) {
            return false;
        }
        int[] freq = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            freq[s1.charAt(i) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
        }
        int count = 0;
        for (int i = 0; i < 26; i++) {
            if (freq[i] != 0) {
                count++;
            }
        }
        if (count == 0) {
            return true;
        }
        for (int i = s1.length(); i < s2.length(); i++) {
            int index1 = s2.charAt(i) - 'a';
            if (freq[index1] == 0) {
                count++;
            } else if (freq[index1] == 1) {
                count--;
            }
            freq[index1]--;
            int index2 = s2.charAt(i - s1.length()) - 'a';
            if (freq[index2] == 0) {
                count++;
            } else if (freq[index2] == -1) {
                count--;
            }
            freq[index2]++;
            if (count == 0) {
                return true;
            }
        }
        return false;
    }
}
