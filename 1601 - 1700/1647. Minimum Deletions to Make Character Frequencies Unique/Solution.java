import java.util.HashSet;
import java.util.Set;

class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        Set<Integer> set = new HashSet<>();
        int res = 0;
        for (int i = 0; i < 26; i++) {
            while (count[i] > 0 && set.contains(count[i])) {
                count[i]--;
                res++;
            }
            set.add(count[i]);
        }
        return res;
    }
}
