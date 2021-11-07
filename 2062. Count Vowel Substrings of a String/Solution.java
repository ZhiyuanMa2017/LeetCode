import java.util.HashSet;
import java.util.Set;

class Solution {
    public static int countVowelSubstrings(String word) {
        int n = word.length();
        int res = 0;
        for (int i = 0; i < n; i++) {
            if (isVowel(word.charAt(i))) {
                Set<Character> set = new HashSet<>();
                for (int j = i; j < n; j++) {
                    if (isVowel(word.charAt(j))) {
                        set.add(word.charAt(j));
                        if (check(set)) {
                            res++;
                        }
                    } else {
                        break;
                    }
                }
            }
        }
        return res;
    }

    private static boolean isVowel(Character s) {
        return s == 'a' || s == 'e' || s == 'i' || s == 'o' || s == 'u';
    }

    private static boolean check(Set<Character> set) {
        if (set.contains('a') && set.contains('e') && set.contains('i') && set.contains('o') && set.contains('u')) {
            return true;
        }
        return false;
    }
}
