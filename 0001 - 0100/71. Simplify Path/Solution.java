import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public String simplifyPath(String path) {
        Deque<String> stack = new LinkedList<>();
        String[] paths = path.split("/");

        for (String s : paths) {
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else if (s.equals(".") || s.equals("")) {
                continue;
            } else {
                stack.push(s);
            }
        }
        StringBuilder stringBuilder = new StringBuilder("/");
        while (!stack.isEmpty()) {
            stringBuilder.append(stack.pollLast());
            if (!stack.isEmpty()) {
                stringBuilder.append("/");
            }
        }
        return stringBuilder.toString();
    }
}
