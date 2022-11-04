import java.util.Arrays;
import java.util.HashSet;

class Solution {
    public String reverseVowels(String s) {
        HashSet<Character> vowels = new HashSet<>(Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
        int l = 0;
        int r = s.length() - 1;
        char[] ss = s.toCharArray();
        while (l < r) {
            while(l < r && !vowels.contains(ss[l])) {
                l++;
            }
            while(l < r && !vowels.contains(ss[r])) {
                r--;
            }
            char tmp = ss[l];
            ss[l] = ss[r];
            ss[r] = tmp;
            l++;
            r--;
        }
        return String.valueOf(ss);
    }
}