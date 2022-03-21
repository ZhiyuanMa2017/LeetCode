import java.util.ArrayList;
import java.util.List;

class Solution2 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        for (int i = 0; i < s.length(); i++) {
            last[s.charAt(i) - 'a'] = i;
        }
        int j = 0;
        int pre = 0;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            j = Math.max(j, last[s.charAt(i) - 'a']);
            if (j == i) {
                j++;
                res.add(j - pre);
                pre = j;
            }
        }
        return res;
    }
}
