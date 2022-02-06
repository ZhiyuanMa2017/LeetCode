import java.util.Arrays;

class Solution {
    public long smallestNumber(long num) {
        if (num == 0) {
            return 0;
        }
        String s = String.valueOf(num);
        if (s.charAt(0) == '-') {
            String ss = s.substring(1);
            char[] chars = ss.toCharArray();
            Arrays.sort(chars);
            StringBuilder sb = new StringBuilder(String.valueOf(chars));
            sb.reverse();
            return Long.parseLong("-" + sb);
        } else {
            char[] chars = s.toCharArray();
            Arrays.sort(chars);
            if (chars[0] == '0') {
                int i;
                for (i = 0; i < chars.length; i++) {
                    if (chars[i] != '0') {
                        break;
                    }
                }
                chars[0] = chars[i];
                chars[i] = '0';
            }
            return Long.parseLong(String.valueOf(chars));
        }
    }
}
