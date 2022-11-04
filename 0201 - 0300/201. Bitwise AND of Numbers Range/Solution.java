class Solution {
    public int rangeBitwiseAnd(int left, int right) {
        int i = 0;
        while (left < right) {
            left >>= 1;
            right >>= 1;
            i++;
        }
        return left << i;
    }
}
