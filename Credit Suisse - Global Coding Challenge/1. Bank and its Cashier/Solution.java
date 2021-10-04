class Solution {
    public static int solution(int n) {
        int quotient = n / 3;
        int remainder = n % 3;
        return quotient + quotient + (remainder > 0 ? 1 : 0);
    }
}
