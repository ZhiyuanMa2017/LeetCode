class Solution {
    public int pivotInteger(int n) {
        int square = (n * n + n) / 2;
        int x = (int) Math.sqrt(square);
        if (x * x == square) {
            return x;
        }
        return -1;
    }
}
