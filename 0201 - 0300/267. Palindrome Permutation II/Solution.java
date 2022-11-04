import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {

    public List<String> generatePalindromes(String s) {
        int odd = 0;
        String mid = "";
        List<String> res = new ArrayList<>();
        List<Character> list = new ArrayList<>();
        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, map.getOrDefault(c, 0) + 1);
            odd += map.get(c) % 2 == 0 ? -1 : 1;
        }
        if (odd > 1) {
            return res;
        }
        for (Character c : map.keySet()) {
            int val = map.get(c);
            if (val % 2 == 1) {
                mid = "" + c;
            }
            for (int i = 0; i < val / 2; i++) {
                list.add(c);
            }
        }
        permute(res, new boolean[list.size()], list, new StringBuilder(), mid);
        return res;
    }

    private void permute(List<String> res, boolean[] used,
                         List<Character> list, StringBuilder s, String mid) {
        if (s.length() == list.size()) {
            res.add(s.toString() + mid + s.reverse().toString());
            s.reverse();
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i > 0 && list.get(i) == list.get(i - 1) && !used[i - 1]) {
                continue;
            }
            if (!used[i]) {
                s.append(list.get(i));
                used[i] = true;
                permute(res, used, list, s, mid);
                s.setLength(s.length() - 1);
                used[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.generatePalindromes("aaaaaa"));
    }
}
