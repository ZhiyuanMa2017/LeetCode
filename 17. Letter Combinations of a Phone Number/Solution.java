import java.util.LinkedList;
import java.util.List;

class Solution {
    public List<String> letterCombinations(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] phone =
                new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        while (ans.peek().length() != digits.length()) {
            String stringNeededtoAddLetter = ans.poll();
            String beAddedLetters = phone[digits.charAt(stringNeededtoAddLetter.length()) - '0'];
            for (char c : beAddedLetters.toCharArray()) {
                ans.add(stringNeededtoAddLetter + c);
            }
        }
        return ans;
    }
}
