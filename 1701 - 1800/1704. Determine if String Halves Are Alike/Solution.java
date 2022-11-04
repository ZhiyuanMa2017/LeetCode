import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean halvesAreAlike(String s) {
        Set<Character> set = new HashSet<>(
                Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));

        int counta = 0, countb = 0;
        for (int i = 0; i < s.length() / 2; i++) {
            if (set.contains(s.charAt(i))) {
                counta++;
            }
        }
        for (int j = s.length() / 2; j < s.length(); j++) {
            if (set.contains(s.charAt(j))) {
                countb++;
            }
        }
        return counta == countb;
    }
}
