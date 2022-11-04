import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public String findReplaceString(String s, int[] indices, String[] sources, String[] targets) {
        int k = indices.length;
        List<Node> list = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            list.add(new Node(indices[i], sources[i], targets[i]));
        }
        Collections.sort(list, (a, b) -> a.index - b.index);
        StringBuilder sb = new StringBuilder();
        int cur = 0;
        for (Node node : list) {
            int index = node.index;
            sb.append(s.substring(cur, index));
            cur = index;
            String source = node.source;
            String target = node.target;
            int len = source.length();
            if (index + len <= s.length()) {
                String sub = s.substring(index, index + len);
                if (sub.equals(source)) {
                    sb.append(target);
                    cur = index + len;
                }
            }
        }
        sb.append(s.substring(cur));
        return sb.toString();
    }

    class Node {
        int index;
        String source;
        String target;

        Node(int i, String s, String t) {
            index = i;
            source = s;
            target = t;
        }
    }
}
