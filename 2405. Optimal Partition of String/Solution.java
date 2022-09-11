import java.util.HashSet;
import java.util.Set;

class Solution {
    public int partitionString(String s) {
        Set<Character> set = new HashSet<>();
        int res = 1;
        for (int i = 0; i < s.length(); i++) {
            if (set.contains(s.charAt(i))) {
                res++;
                set = new HashSet<>();
            }
            set.add(s.charAt(i));
        }
        return res;
    }
}
