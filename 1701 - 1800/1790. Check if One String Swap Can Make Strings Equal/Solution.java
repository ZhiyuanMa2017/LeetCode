import java.util.ArrayList;
import java.util.List;

class Solution {
    public boolean areAlmostEqual(String s1, String s2) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                list.add(i);
                if (list.size() > 2) {
                    return false;
                }
            }
        }
        if (list.size() == 0) {
            return true;
        } else if (list.size() == 1) {
            return false;
        }
        int first = list.get(0);
        int second = list.get(1);
        return s1.charAt(first) == s2.charAt(second) && s1.charAt(second) == s2.charAt(first);
    }
}
