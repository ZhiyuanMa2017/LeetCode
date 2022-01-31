import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String countOfAtoms(String formula) {
        int n = formula.length();
        Map<String, Integer> count = new HashMap<>();
        Deque<Integer> stack = new ArrayDeque<>();

        int product = 1;
        for (int i = n - 1; i >= 0; i--) {
            char c = formula.charAt(i);
            if (c == '(') {
                product /= stack.pop();
            } else {
                int rank = 1;
                int multiply = 0;
                while (Character.isDigit(c)) {
                    multiply += rank * (c - '0');
                    rank *= 10;
                    i--;
                    c = formula.charAt(i);
                }
                if (multiply == 0) {
                    multiply = 1;
                }
                stack.push(multiply);
                product *= multiply;
                if (c == ')') {
                    continue;
                }
                StringBuilder atom = new StringBuilder();
                while (Character.isLowerCase(c)) {
                    atom.insert(0, c);
                    i--;
                    c = formula.charAt(i);
                }
                atom.insert(0, c);
                String name = atom.toString();
                count.put(name, count.getOrDefault(name, 0) + product);
                product /= stack.pop();
            }
        }
        List<String> l = new ArrayList<>(count.keySet());
        Collections.sort(l);
        StringBuilder sb = new StringBuilder();
        for (String s : l) {
            sb.append(s);
            if (count.get(s) > 1) {
                sb.append(count.get(s));
            }
        }
        return sb.toString();
    }
}
