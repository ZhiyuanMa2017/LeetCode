import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public boolean isValid(String code) {
        String cdataBegin = "<![CDATA[";
        String cdataEnd = "]]>";
        Deque<String> stack = new ArrayDeque<>();
        int i = 0;
        int n = code.length();
        while (i < n) {
            if (i + 9 <= n && code.substring(i, i + 9).equals(cdataBegin)) {
                if (i == 0) {
                    return false;
                }
                int j = i + 9;
                boolean findEnd = false;
                while (j < n && !findEnd) {
                    if (j + 3 <= n && code.substring(j, j + 3).equals(cdataEnd)) {
                        findEnd = true;
                        j = j + 3;
                    } else {
                        j++;
                    }
                }
                if (!findEnd) {
                    return false;
                }
                i = j;
            } else if (code.charAt(i) == '<') {
                if (i == n - 1) {
                    return false;
                }
                boolean isEnd = code.charAt(i + 1) == '/';
                int tagBeginIndex = isEnd ? i + 2 : i + 1;
                int j = tagBeginIndex;
                while (j < n && code.charAt(j) != '>') {
                    if (!Character.isUpperCase(code.charAt(j))) {
                        return false;
                    }
                    j++;
                }
                if (j == n) {
                    return false;
                }
                int len = j - tagBeginIndex;
                if (len < 1 || len > 9) {
                    return false;
                }
                String tagName = code.substring(tagBeginIndex, j);
                i = j + 1;
                if (!isEnd) {
                    stack.push(tagName);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    if (!stack.pop().equals(tagName)) {
                        return false;
                    }
                    if (stack.isEmpty() && i < n) {
                        return false;
                    }
                }
            } else {
                if (i == 0) {
                    return false;
                }
                i++;
            }
        }
        return stack.isEmpty();
    }
}
