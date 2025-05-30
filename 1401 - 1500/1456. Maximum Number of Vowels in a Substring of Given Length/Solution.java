import java.util.HashSet;
import java.util.Set;

class Solution {
    public int maxVowels(String s, int k) {
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e');
        set.add('i');
        set.add('o');
        set.add('u');
        int res = 0;
        for (int i = 0; i < k; i++) {
            if (set.contains(s.charAt(i))) {
                res++;
            }
        }
        int cur = res;
        for (int i = k; i < s.length(); i++) {
            int j = i - k;
            if (set.contains(s.charAt(j))) {
                cur--;
            }
            if (set.contains(s.charAt(i))) {
                cur++;
            }
            res = Math.max(res, cur);
        }
        return res;
    }
}
