class Solution {
    public String reorganizeString(String s) {
        int[] count = new int[26];
        int max = 0;
        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            count[cur]++;
            if (count[cur] > max) {
                max = count[cur];
                index = cur;
            }
        }
        if (max > (s.length() + 1) / 2) {
            return "";
        }
        char[] res = new char[s.length()];
        int i = 0;
        while (count[index] > 0) {
            res[i] = (char) (index + 'a');
            count[index]--;
            i += 2;
        }
        for (int j = 0; j < 26; j++) {
            while (count[j] > 0) {
                if (i >= s.length()) {
                    i = 1;
                }
                res[i] = (char) (j + 'a');
                count[j]--;
                i += 2;
            }
        }
        return new String(res);
    }
}
