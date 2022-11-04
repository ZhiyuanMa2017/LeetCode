class Solution {
    public int minMoves(int target, int maxDoubles) {
        int move = 0;
        while (target != 1) {
            if (target % 2 == 0 && maxDoubles > 0) {
                target /= 2;
                maxDoubles--;
            } else if (maxDoubles > 0) {
                target--;
            } else {
                move += target - 1;
                return move;
            }
            move++;
        }
        return move;
    }
}
