class Solution2 {
    public int myAtoi(String s) {
        int index = 0;
        int total = 0;
        int sign = 1;
        if (s.length() == 0) {
            return 0;
        }
        while (index < s.length() && s.charAt(index) == ' ') {
            index++;
        }
        if (index == s.length()) {
            return 0;
        }
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < s.length()) {
            if (!Character.isDigit(s.charAt(index))) {
                break;
            }
            int digit = s.charAt(index) - '0';

            if (Integer.MAX_VALUE / 10 < total
                    || Integer.MAX_VALUE / 10 == total && Integer.MAX_VALUE % 10 < digit) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            total = total * 10 + digit;

            index++;
        }
        return total * sign;
    }
}
