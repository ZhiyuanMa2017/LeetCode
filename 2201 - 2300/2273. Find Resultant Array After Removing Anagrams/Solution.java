import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.List;

class Solution {
    public List<String> removeAnagrams(String[] words) {
        Deque<String> stack = new ArrayDeque<>();
        for (String word : words) {
            if (stack.isEmpty()) {
                stack.push(word);
            } else {
                if (!check(stack.peek(), word)) {
                    stack.push(word);
                }
            }
        }
        List<String> res = new ArrayList<>();
        while (!stack.isEmpty()) {
            res.add(stack.pop());
        }
        Collections.reverse(res);
        return res;
    }

    private boolean check(String a, String b) {
        char[] aaa = a.toCharArray();
        char[] bbb = b.toCharArray();
        if (aaa.length != bbb.length) {
            return false;
        }
        Arrays.sort(aaa);
        Arrays.sort(bbb);
        return new String(aaa).equals(new String(bbb));
    }
}
