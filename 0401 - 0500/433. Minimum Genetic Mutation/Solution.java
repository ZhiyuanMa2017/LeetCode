import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String start, String end, String[] bank) {
        Set<String> set = new HashSet<>(Arrays.asList(bank));
        if (!set.contains(end)) {
            return -1;
        }
        Queue<String> queue = new LinkedList<>();
        queue.offer(start);
        int step = 0;
        char[] valid = new char[]{'A', 'C', 'G', 'T'};
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(end)) {
                    return step;
                }
                char[] chars = cur.toCharArray();
                for (int j = 0; j < chars.length; j++) {
                    char c = chars[j];
                    for (char v : valid) {
                        if (c == v) {
                            continue;
                        }
                        chars[j] = v;
                        String next = new String(chars);
                        if (set.contains(next)) {
                            queue.offer(next);
                            set.remove(next);
                        }
                    }
                    chars[j] = c;
                }
            }
            step++;
        }
        return -1;
    }
}
