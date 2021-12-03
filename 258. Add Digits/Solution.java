class Solution {
    public int addDigits(int num) {
        String s = String.valueOf(num);
        while (s.length() > 1) {
            int sum = 0;
            for (int i = 0; i < s.length(); i++) {
                sum += s.charAt(i) - '0';
            }
            s = String.valueOf(sum);
        }
        return Integer.parseInt(s);
    }
}
