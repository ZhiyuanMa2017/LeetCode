import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Solution {

    public static String sExpression(String nodes) {
        int edges = 0;
        Map<Integer, List<Integer>> parentChild = new HashMap<>();
        String[] pairs = nodes.split(" ");
        Set<Integer> children = new HashSet<>();
        for (String pair : pairs) {
            int parent = pair.charAt(1) - 'A';
            int child = pair.charAt(3) - 'A';
            List<Integer> childList = parentChild.getOrDefault(parent, new ArrayList<>());
            if (childList.contains(child)) {
                return "E2";
            } else if (childList.size() == 2) {
                return "E1";
            }
            childList.add(child);
            parentChild.put(parent, childList);
            children.add(child);
            edges++;
        }

        Set<Integer> all = new HashSet<>();
        all.addAll(children);
        all.addAll(parentChild.keySet());
        if (edges >= all.size()) {
            return "E3";
        }

        int countRoots = 0;
        int rootIndex = -1;
        Set<Integer> parents = parentChild.keySet();
        for (Integer p : parents) {
            if (!children.contains(p)) {
                countRoots++;
                if (countRoots >= 2) {
                    return "E4";
                }
                rootIndex = p;
            }
        }

        return helper(rootIndex, parentChild).toString();
    }

    public static StringBuilder helper(int currentIndex, Map<Integer, List<Integer>> parentChild) {
        if (!parentChild.containsKey(currentIndex)) {
            StringBuilder str = new StringBuilder().append("(");
            char cur = (char) ('A' + currentIndex);
            str.append(cur).append(")");
            return str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("(").append((char) ('A' + currentIndex));
        List<Integer> childList = parentChild.get(currentIndex);
        Collections.sort(childList);
        for (Integer c : childList) {
            sb.append(helper(c, parentChild));
        }
        sb.append(")");
        return sb;
    }

    public static void main(String[] args) {
        //   Error Code           Type of error
        //     E1                 More than 2 children
        //     E2                 Duplicate Edges
        //     E3                 Cycle present
        //     E4                 Multiple roots
        //     E5                 Any other error
        String test = "(A,B) (A,C) (B,D) (D,C)";
        // E3
        String test2 = "(A,B) (A,C) (B,D) (E,F) (F,G) (F,H)";
        // E4
        String test3 = "(B,D) (D,E) (A,B) (C,F) (E,G) (A,C)";
        // (A(B(D(E(G))))(C(F)))
        String test4 = "(A,C) (B,C)";
        System.out.println(constructSExpression(test));
        System.out.println(constructSExpression(test2));
        System.out.println(constructSExpression(test3));
        System.out.println(constructSExpression(test4));
    }
}
