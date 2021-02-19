import java.util.Stack;

class Solution {
    public String minRemoveToMakeValid(String s) {
        Stack<Integer> stack = new Stack<>();
        boolean[] booleans = new boolean[s.length()];

        for (int i = 0; i < s.length(); i++) {
            booleans[i] = true;
            if ('(' == s.charAt(i)) {
                stack.push(i);
                booleans[i] = false;
            }
            if (')' == s.charAt(i)) {
                if (!stack.isEmpty()) {
                    booleans[stack.pop()] = true;
                } else {
                    booleans[i] = false;
                }
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            if (booleans[i]) {
                stringBuilder.append(s.charAt(i));
            }
        }
        return stringBuilder.toString();
    }
}
