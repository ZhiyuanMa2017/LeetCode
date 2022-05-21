import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> printVertically(String s) {
        List<String> res = new ArrayList<>();
        String[] words = s.split(" ");
        int maxLen = 0;
        for (String word : words) {
            maxLen = Math.max(maxLen, word.length());
        }
        for (int i = 0; i < maxLen; i++) {
            StringBuilder sb = new StringBuilder();
            for (String word : words) {
                if (i >= word.length()) {
                    sb.append(" ");
                } else {
                    sb.append(word.charAt(i));
                }
            }
            res.add(sb.toString().stripTrailing());
        }
        return res;
    }
}
