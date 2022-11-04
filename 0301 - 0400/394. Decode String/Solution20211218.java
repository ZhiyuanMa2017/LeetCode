import java.util.Stack;

class Solution20211218 {
    public String decodeString(String s) {
        Stack<Integer> nums = new Stack<>();
        Stack<StringBuilder> strings = new Stack<>();
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                count = count * 10 + s.charAt(i) - '0';
            } else if (s.charAt(i) == '[') {
                nums.push(count);
                strings.push(sb);
                count = 0;
                sb = new StringBuilder();
            } else if (s.charAt(i) == ']') {
                int thisNumber = nums.pop();
                StringBuilder prev = strings.pop();
                for (int j = 0; j < thisNumber; j++) {
                    prev.append(sb);
                }
                sb = prev;
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
// s = "3[a]2[bc]"
// Output: "aaabcbc"
