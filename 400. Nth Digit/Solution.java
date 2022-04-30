class Solution {
    public int findNthDigit(int n) {
        int digits = 1;
        long nines = 9;
        while (n > digits * nines) {
            n -= digits * nines;
            digits++;
            nines *= 10;
        }
        int start = (int) Math.pow(10, digits - 1);
        int num = start + (n - 1) / digits;
        int index = (n - 1) % digits;
        return String.valueOf(num).charAt(index) - '0';
    }
}
