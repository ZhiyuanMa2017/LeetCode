import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<String> commonChars(String[] words) {
        int[] count = new int[26];
        Arrays.fill(count, 101);
        for (String word : words) {
            int[] tmp = new int[26];
            for (int i = 0; i < word.length(); i++) {
                tmp[word.charAt(i) - 'a']++;
            }
            for (int i = 0; i < 26; i++) {
                count[i] = Math.min(count[i], tmp[i]);
            }
        }
        List<String> res = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                String s = String.valueOf((char) (i + 'a'));
                for (int j = 0; j < count[i]; j++) {
                    res.add(s);
                }
            }
        }
        return res;
    }
}
