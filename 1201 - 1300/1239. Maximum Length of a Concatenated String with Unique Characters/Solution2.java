import java.util.ArrayList;
import java.util.List;

class Solution {
    public int maxLength(List<String> arr) {
        List<Integer> list = new ArrayList<>();
        list.add(0);
        for (String s : arr) {
            int b = toBinary(s);
            if (b == -1) {
                continue;
            }
            List<Integer> tmp = new ArrayList<>();
            for (Integer prev : list) {
                if ((prev & b) == 0) {
                    tmp.add(prev | b);
                }
            }
            list.addAll(tmp);
        }
        int res = 0;
        for (Integer integer : list) {
            res = Math.max(res, Integer.bitCount(integer));
        }
        return res;
    }

    private int toBinary(String s) {
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            int shift = s.charAt(i) - 'a';
            if ((res >> shift & 1) == 1) {
                return -1;
            }
            res |= 1 << shift;
        }
        return res;
    }
}
