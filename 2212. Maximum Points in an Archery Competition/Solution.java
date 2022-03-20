class Solution {
    int[] res;
    int max;

    public int[] maximumBobPoints(int numArrows, int[] aliceArrows) {
        int n = aliceArrows.length;
        int[] path = new int[n];
        res = new int[n];
        max = 0;
        backtrack(numArrows, aliceArrows, path, 11, 0);
        return res;
    }

    private void backtrack(int remainArrows, int[] aliceArrows, int[] path, int curSection, int bobPoints) {
        if (curSection < 0 || remainArrows <= 0) {
            if (bobPoints > max) {
                if (remainArrows > 0) {
                    path[0] += remainArrows;
                }
                System.arraycopy(path, 0, res, 0, path.length);
                max = bobPoints;
            }
            return;
        }
        int cur = aliceArrows[curSection];
        if (remainArrows >= cur + 1) {
            path[curSection] = cur + 1;
            backtrack(remainArrows - path[curSection], aliceArrows, path, curSection - 1, bobPoints + curSection);
            path[curSection] = 0;
        }
        backtrack(remainArrows, aliceArrows, path, curSection - 1, bobPoints);
    }
}
