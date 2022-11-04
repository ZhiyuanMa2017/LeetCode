import java.util.ArrayList;
import java.util.List;

class Solution {
    public String[] findWords(String[] words) {
        String[] keyboard = new String[]{"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        int[] table = new int[26];
        for (int i = 0; i < keyboard.length; i++) {
            String row = keyboard[i];
            for (int j = 0; j < row.length(); j++) {
                table[row.charAt(j) - 'a'] = i;
            }
        }
        List<String> res = new ArrayList<>();
        for (String word : words) {
            int index = table[Character.toLowerCase(word.charAt(0)) - 'a'];
            boolean flag = true;
            for (int i = 1; i < word.length(); i++) {
                char c = Character.toLowerCase(word.charAt(i));
                if (index != table[c - 'a']) {
                    flag = false;
                    break;
                }
            }
            if (flag) {
                res.add(word);
            }
        }
        return res.toArray(new String[0]);
    }
}
