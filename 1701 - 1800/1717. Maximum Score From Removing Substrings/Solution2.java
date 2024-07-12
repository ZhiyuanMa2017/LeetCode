class Solution {
    public int maximumGain(String s, int x, int y) {
        int res = 0;
        char[] chars = new char[]{'a', 'b'};
        int large = x;
        int small = y;
        if (x < y) {
            chars = new char[]{'b', 'a'};
            large = y;
            small = x;
        }
        int count0 = 0;
        int count1 = 0;
        for (char c : s.toCharArray()) {
            if (c == chars[0]) {
                count0++;
            } else if (c == chars[1]) {
                if (count0 > 0) {
                    count0--;
                    res += large;
                } else {
                    count1++;
                }
            } else {
                res += small * Math.min(count0, count1);
                count0 = 0;
                count1 = 0;
            }
        }
        res += small * Math.min(count0, count1);
        return res;
    }
}
