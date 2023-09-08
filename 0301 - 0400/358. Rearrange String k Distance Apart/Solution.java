import java.util.Arrays;

class Solution {
    public String rearrangeString(String s, int k) {
        if (k == 0) {
            return s;
        }
        int n = s.length();
        int[][] count = new int[26][2];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            count[c - 'a'][1]++;
        }
        for (int i = 0; i < 26; i++) {
            count[i][0] = i;
        }
        Arrays.sort(count, (a, b) -> b[1] - a[1]);
        int max = count[0][1];
        int maxCount = 1;
        for (int i = 1; i < 26; i++) {
            if (count[i][1] == max) {
                maxCount++;
            } else {
                break;
            }
        }
        if ((max - 1) * k + maxCount > n) {
            return "";
        }
        char[] res = new char[s.length()];
        int i = (n - 1) % k;
        for (int j = 0; j < 26; j++) {
            char c = (char) ('a' + count[j][0]);
            while (count[j][1] > 0) {
                res[i] = c;
                count[j][1]--;
                i += k;
                if (i >= n) {
                    i = (i - 1) % k;
                }
            }
        }
        return new String(res);
    }
}
