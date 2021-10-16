import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        Map<String, Integer> wordMap = new HashMap<>();
        int len = words[0].length();
        int num = words.length;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            wordMap.put(words[i], wordMap.getOrDefault(words[i], 0) + 1);
        }
        for (int i = 0; i < len; i++) {
            int left = i;
            int right = i;
            int count = 0;
            Map<String, Integer> tmp = new HashMap<>();
            while (right + len <= s.length()) {
                String str = s.substring(right, right + len);
                right += len;
                if (!wordMap.containsKey(str)) {
                    count = 0;
                    left = right;
                    tmp.clear();
                } else {
                    tmp.put(str, tmp.getOrDefault(str, 0) + 1);
                    count++;
                    while (tmp.getOrDefault(str, 0) > wordMap.getOrDefault(str, 0)) {
                        String strLeftMost = s.substring(left, left + len);
                        count--;
                        tmp.put(strLeftMost, tmp.getOrDefault(strLeftMost, 0) - 1);
                        left += len;
                    }
                    if (count == num) {
                        res.add(left);
                    }
                }
            }
        }
        return res;
    }
}
