import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<String> letterCombinations(String digits) {
        List<String> list = new ArrayList<>();
        if (digits.length() == 0) {
            return list;
        }
        String[] phone = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        list.add("");
        for (int i = 0; i < digits.length(); i++) {
            int cur = digits.charAt(i) - '0';
            List<String> temp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                String s = list.get(j);
                for (char c : phone[cur].toCharArray()) {
                    temp.add(s + c);
                }
            }
            list = temp;
        }
        return list;
    }
}
