import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Solution {
    public int minDeletions(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            if (count[i] > 0) {
                list.add(count[i]);
            }
        }
        Collections.sort(list);
        Collections.reverse(list);
        int res = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i) >= list.get(i - 1)) {
                if (list.get(i - 1) == 0) {
                    res += list.get(i);
                    list.set(i, 0);
                } else {
                    res += list.get(i) - list.get(i - 1) + 1;
                    list.set(i, list.get(i - 1) - 1);
                }
            }
        }
        return res;
    }
}
