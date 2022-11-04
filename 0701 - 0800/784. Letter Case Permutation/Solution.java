import java.util.ArrayList;
import java.util.List;

class Solution {
    List<String> res = new ArrayList<>();

    public List<String> letterCasePermutation(String s) {
        permute(s.toCharArray(), 0);
        return res;
    }

    private void permute(char[] chars, int index) {
        if (index == chars.length) {
            res.add(new String(chars));
        } else {
            permute(chars, index + 1);
            if (Character.isLowerCase(chars[index])) {
                chars[index] = (char) (chars[index] - 'a' + (int) 'A');
                permute(chars, index + 1);
                chars[index] = (char) (chars[index] - 'A' + (int) 'a');
            }
            if (Character.isUpperCase(chars[index])) {
                chars[index] = (char) (chars[index] - 'A' + (int) 'a');
                permute(chars, index + 1);
                chars[index] = (char) (chars[index] - 'a' + (int) 'A');
            }
        }
    }
}
