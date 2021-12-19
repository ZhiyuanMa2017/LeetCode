import java.util.Stack;

public class Solution {
    public static String decodeString(String s) {
        Stack<Integer> number = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        StringBuilder tmp = new StringBuilder();
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count = count * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                number.push(count);
                strings.push(tmp);
                count = 0;
                tmp = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                int thisnumber = number.pop();
                StringBuilder prevs = strings.pop();
                for (int i1 = 0; i1 < thisnumber; i1++) {
                    prevs.append(tmp);
                }
                tmp = prevs;
            } else {
                tmp.append(s.charAt(i));
            }
        }
        return tmp.toString();
    }
}
