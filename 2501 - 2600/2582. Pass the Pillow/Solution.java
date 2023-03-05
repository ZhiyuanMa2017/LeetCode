class Solution {
    public int passThePillow(int n, int time) {
        int cur = 1;
        int d = 1;
        while (time > 0) {
            cur += d;
            if (cur == n) {
                d = -1;
            }
            if (cur == 1) {
                d = 1;
            }
            time--;
        }
        return cur;
    }
}
