import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> partitionLabels(String s) {
        int[] count = new int[26];
        for (int i = 0; i < s.length(); i++) {
            count[s.charAt(i) - 'a']++;
        }
        int index = 0;
        int changed = 0;
        int finished = 0;
        boolean[] used = new boolean[26];
        int pre = 0;
        List<Integer> res = new ArrayList<>();
        while (index < s.length()) {
            char c = s.charAt(index);
            if (!used[c - 'a']) {
                used[c - 'a'] = true;
                changed++;
            }
            count[c - 'a']--;
            if (count[c - 'a'] == 0) {
                finished++;
            }
            index++;
            if (finished == changed) {
                res.add(index - pre);
                pre = index;
            }

        }
        return res;
    }
}
