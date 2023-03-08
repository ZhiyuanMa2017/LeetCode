import java.util.HashSet;
import java.util.Set;

class Solution {
    public int shortestWay(String source, String target) {
        Set<Character> set = new HashSet<>();
        for (char c : source.toCharArray()) {
            set.add(c);
        }
        int res = 1;
        int i = 0;
        for (int j = 0; j < target.length(); j++) {
            char c = target.charAt(j);
            if (!set.contains(c)) {
                return -1;
            }
            if (i == source.length()) {
                i = 0;
                res++;
            }
            while (source.charAt(i) != c) {
                i++;
                if (i == source.length()) {
                    i = 0;
                    res++;
                }
            }
            i++;
        }
        return res;
    }
}
