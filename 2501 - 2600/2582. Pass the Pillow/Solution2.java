class Solution {
    public int passThePillow(int n, int time) {
        int round = time / (n - 1);
        int remain = time % (n - 1);
        if (round % 2 == 0) {
            return remain + 1;
        } else {
            return n - remain;
        }
    }
}
