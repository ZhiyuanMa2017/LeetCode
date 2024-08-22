import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> generateAbbreviations(String word) {
        List<String> res = new ArrayList<>();
        backtrack(0, new StringBuilder(), true, word, res);
        return res;
    }

    private void backtrack(int start, StringBuilder sb, boolean can, String word, List<String> res) {
        if (start == word.length()) {
            res.add(sb.toString());
            return;
        }
        if (can) {
            for (int i = start; i < word.length(); i++) {
                String cur = String.valueOf(i - start + 1);
                sb.append(cur);
                backtrack(i + 1, sb, false, word, res);
                sb.setLength(sb.length() - cur.length());
            }
        }
        sb.append(word.charAt(start));
        backtrack(start + 1, sb, true, word, res);
        sb.setLength(sb.length() - 1);
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        List<String> res = s.generateAbbreviations("dictionary");
        System.out.println(res.size());
        for (String re : res) {
            System.out.println(re);
        }
    }
}
