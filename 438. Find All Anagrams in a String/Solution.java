import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        int[] count = new int[26];
        int[] window = new int[26];
        int len = s.length();
        int n = p.length();
        List<Integer> res = new ArrayList<>();
        if (n > len) {
            return res;
        }
        for (int i = 0; i < n; i++) {
            count[p.charAt(i) - 'a']++;
        }
        for (int i = 0; i < n; i++) {
            window[s.charAt(i) - 'a']++;
        }
        if (Arrays.equals(count, window)) {
            res.add(0);
        }
        for (int i = 1; i < s.length() - n + 1; i++) {
            int left = i;
            int right = left + n - 1;
            window[s.charAt(left - 1) - 'a']--;
            window[s.charAt(right) - 'a']++;
            if (Arrays.equals(count, window)) {
                res.add(i);
            }
        }
        return res;
    }
}
