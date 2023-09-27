class Solution {
    public String decodeAtIndex(String s, int k) {
        long len = 0;
        int index = 0;
        while (index < s.length() && len < k) {
            if (Character.isDigit(s.charAt(index))) {
                len *= s.charAt(index) - '0';
            } else {
                len++;
            }
            index++;
        }
        index--;
        while (true) {
            if (Character.isDigit(s.charAt(index))) {
                int num = s.charAt(index) - '0';
                len /= num;
                k %= len;
            } else if (k % len == 0) {
                return String.valueOf(s.charAt(index));
            } else {
                len--;
            }
            index--;
        }
    }
}
