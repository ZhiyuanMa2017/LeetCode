class Solution {
    public int[] evenOddBit(int n) {
        int evenMask = 0b010101010101;
        int oddMask = 0b101010101010;
        return new int[]{Integer.bitCount(evenMask & n), Integer.bitCount(oddMask & n)};
    }
}
