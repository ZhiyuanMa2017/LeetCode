import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution20210121 {
    public List<Integer> findSubstring(String s, String[] words) {
        int n = s.length();
        int len = words[0].length();
        int total = words.length;
        Map<String, Integer> wordCount = new HashMap<>();
        for (String word : words) {
            wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
        }
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> cur = new HashMap<>();
            while (right + len <= n) {
                String str = s.substring(right, right + len);
                right += len;
                if (!wordCount.containsKey(str)) {
                    count = 0;
                    left = right;
                    cur.clear();
                } else {
                    cur.put(str, cur.getOrDefault(str, 0) + 1);
                    count++;
                    while (cur.getOrDefault(str, 0) > wordCount.getOrDefault(str, 0)) {
                        count--;
                        String l = s.substring(left, left + len);
                        cur.put(l, cur.getOrDefault(l, 0) - 1);
                        left += len;
                    }
                    if (count == total) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
