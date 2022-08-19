class Solution {
    public int findTheWinner(int n, int k) {
        if (n == 1) {
            return 1;
        }
        int res = (findTheWinner(n - 1, k) + k) % n;
        if (res == 0) {
            return n;
        }
        return res;
    }
}
