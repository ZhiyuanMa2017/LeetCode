import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

class Solution2 {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();
        int step = 1;
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String cur = queue.poll();
                if (cur.equals(endWord)) {
                    return step;
                }
                char[] chars = cur.toCharArray();
                for (int j = 0; j < cur.length(); j++) {
                    char temp = chars[j];
                    for (char c = 'a'; c <= 'z'; c++) {
                        chars[j] = c;
                        String newOne = String.valueOf(chars);
                        if (set.contains(newOne) && !visited.contains(newOne)) {
                            queue.offer(newOne);
                            visited.add(newOne);
                        }
                    }
                    chars[j] = temp;
                }
            }
            step++;
        }
        return 0;
    }
}
