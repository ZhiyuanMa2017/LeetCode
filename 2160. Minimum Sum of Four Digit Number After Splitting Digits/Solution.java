import java.util.Arrays;

class Solution {
    public int minimumSum(int num) {
        int[] digits = new int[4];
        String s = String.valueOf(num);
        for (int i = 0; i < 4; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        Arrays.sort(digits);
        int one = digits[0] * 10 + digits[2];
        int two = digits[1] * 10 + digits[3];
        return one + two;
    }
}
