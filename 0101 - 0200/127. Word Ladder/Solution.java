import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        Set<String> beginSet = new HashSet<>();
        Set<String> endSet = new HashSet<>();
        int step = 1;
        int len = beginWord.length();
        Set<String> visited = new HashSet<>();
        beginSet.add(beginWord);
        endSet.add(endWord);
        while (!beginSet.isEmpty() && !endSet.isEmpty()) {
            if (beginSet.size() > endSet.size()) {
                Set<String> exchange = beginSet;
                beginSet = endSet;
                endSet = exchange;
            }
            Set<String> temp = new HashSet<>();
            for (String s : beginSet) {
                char[] chars = s.toCharArray();
                for (int i = 0; i < len; i++) {
                    for (char c = 'a'; c <= 'z'; c++) {
                        char old = chars[i];
                        chars[i] = c;
                        String newS = String.valueOf(chars);
                        if (endSet.contains(newS)) {
                            return step + 1;
                        }
                        if (!visited.contains(newS) && wordSet.contains(newS)) {
                            temp.add(newS);
                            visited.add(newS);
                        }
                        chars[i] = old;
                    }
                }
            }
            beginSet = temp;
            step++;
        }
        return 0;
    }
}
